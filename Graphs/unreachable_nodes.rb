require "byebug"


class Graph

  def initialize()
    @vertices = Hash.new([])
  end

  def add(vertex, adjesent_nodes = [])
    @vertices[vertex] += adjesent_nodes
  end

  def find_all_adjecent_nodes(vertex)
    @vertices.fetch(vertex)
  end

  def vertices_connected?(node1, node2)
    @vertices.fetch(node1).include? node2
  end

  def add_edge(node1, node2)
    @vertices[node1].push node2
    @vertices[node2].push node1
  end

  def vertices
    @vertices.keys
  end
end


class Dfs
  attr_reader :graph

  def initialize(graph, start)
    @graph = graph
    @stack = []
    @visited_hash = Hash.new
    @start = start
  end

  def call
    @stack.push(@start)
    traverse_list(@stack)
    puts (graph.vertices - visited_hash.keys).length
  end

  private
    attr_reader :visited_hash

    def traverse_list(stack)
      return if stack.empty?

      current_node = stack.pop
      # puts "Visited: #{current_node}"
      visited_hash[current_node] = true

      graph.find_all_adjecent_nodes(current_node).each do |adj_node|
        if visited_hash[adj_node].nil? # means adf_node not visited yet
          stack.push(adj_node)
          traverse_list(stack)
        end
      end

    end
end


graph = Graph.new

vertices_count, edges_count =  gets.chomp.split(' ').map(&:to_i)

1.upto(vertices_count) do |v|
  graph.add(v)
end

edges_count.times do
  node1, node2 = gets.chomp.split(' ').map(&:to_i)
  graph.add_edge(node1, node2)
end


head = gets.chomp.to_i

Dfs.new(graph, head).call


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

  def add_edge(node1, node2)
    @vertices[node1].push node2
    @vertices[node2].push node1
  end
end

class Queue
  attr_reader :list

  def initialize()
    @list = []
  end

  def enqueue(element)
    @list.push element
  end

  def dequeue
    @list.delete_at(0)
  end

  def empty?
    list.empty?
  end
end


class Bfs
  attr_reader :graph, :level

  def initialize(graph, start, level)
    @graph = graph
    @queue = Queue.new
    @visited = Hash.new
    @start = start
    @level = level
  end

  def call
    level_count = 0
    push_to_visited(start, 1)
    queue.enqueue(start)

    until queue.empty?
      v = queue.dequeue
      graph.find_all_adjecent_nodes(v).each do |adj_node|
        if node_not_visited?(adj_node)
          if visited[v] + 1 == level
            level_count += 1
          end
          push_to_visited(adj_node, visited[v] + 1)
          queue.enqueue(adj_node)
        end
      end
    end
    puts(level == 1 ? 1 : level_count)
  end

  private
    attr_reader :queue, :visited, :start

    def push_to_visited(element, level)
      visited[element] = level
    end

    def node_not_visited?(element)
      not visited.key?(element)
    end
end

graph = Graph.new

vertices_count = gets.chomp.to_i

1.upto(vertices_count) do |v|
  graph.add(v)
end

(vertices_count - 1).times do |i|
  puts "Iteration: #{i}"
  node1, node2 = gets.chomp.split(' ').map(&:to_i)
  graph.add_edge(node1, node2)
end

level = gets.chomp.to_i

Bfs.new(graph, 1, level).call


































# class Graph

#   def initialize()
#     @vertices = Hash.new([])
#   end

#   def add(vertex, adjesent_nodes = [])
#     @vertices[vertex] += adjesent_nodes
#   end

#   def find_all_adjecent_nodes(vertex)
#     @vertices.fetch(vertex)
#   end

#   def add_edge(node1, node2)
#     @vertices[node1].push node2
#     @vertices[node2].push node1
#   end
# end

# class Queue
#   attr_reader :list

#   def initialize()
#     @list = []
#   end

#   def enqueue(element)
#     @list.push element
#   end

#   def dequeue
#     @list.delete_at(0)
#   end

#   def empty?
#     list.empty?
#   end
# end


# class Bfs
#   attr_reader :graph, :level

#   def initialize(graph, start, level)
#     @graph = graph
#     @queue = Queue.new
#     @visited = Hash.new
#     @start = start
#     @level = level
#   end

#   def call
#     level_count = 0
#     push_to_visited(start, 1)
#     queue.enqueue(start)

#     until queue.empty?
#       v = queue.dequeue
#       graph.find_all_adjecent_nodes(v).each do |adj_node|
#         if node_not_visited?(adj_node)
#           if visited[v] + 1 == level
#             level_count += 1
#           end
#           push_to_visited(adj_node, visited[v] + 1)
#           queue.enqueue(adj_node)
#         end
#       end
#     end
#     puts level == 1 ? 1 : level_count
#   end

#   private
#     attr_reader :queue, :visited, :start

#     def push_to_visited(element, level)
#       visited[element] = level
#     end

#     def node_not_visited?(element)
#       not visited.key?(element)
#     end
# end





# graph = Graph.new
# # graph.add(0, [1,2])
# # graph.add(1, [0,3])
# # graph.add(2, [0,3,4])
# # graph.add(3, [1,2,5])
# # graph.add(4, [2])
# # graph.add(5, [3])
# # bfs = Bfs.new(graph, 0, 2)
# # bfs.call
# # bfs
# # debugger
# # true
# vertices_count  gets.chomp.to_i

# 1.upto(vertices_count) do |v|
#   graph.add(v)
# end

# vertices_count.times do
#   node1, node2 = gets.chomp.split(' ').map(&:to_i)
#   graph.add_edge(node1, node2)
# end

# level = gets.chomp.to_i
# Bfs.new(graph, 0, level).call

require 'byebug'
require_relative 'graph_adj_list'
require_relative 'stack'


class Dfs
  attr_reader :graph

  def initialize(graph, start)
    @graph = graph
    @stack = Stack.new
    @visited = Hash.new
    @start = start
  end

  def call
    @stack.push(@start)
    traverse_list(@stack, @visited)
    self
  end

  private
    def traverse_list(stack, visited_hash)
      return if stack.empty?

      current_node = stack.pop
      puts "Visited: #{current_node}"
      visited_hash[current_node] = true

      graph.find_all_adjecent_nodes(current_node).each do |adj_node|
        if visited_hash[adj_node].nil? # means adf_node not visited yet
          stack.push(adj_node)
          traverse_list(stack, visited_hash)
        end
      end

    end
end

graph = Graph.new
graph.add(1, [2, 3])
graph.add(2, [4,5,1])
graph.add(3, [1])
graph.add(4, [2])
graph.add(5, [2])
Dfs.new(graph, 1).call


# graph.add(2, [0, 3])
# graph.add(3, [2])
# graph.add(0, [2, 1])
# graph.add(1, [0, 2])
# Dfs.new(graph, 2).call

# graph.add('A', ['B','C'])
# graph.add('B', ['A', 'D', 'E'])
# graph.add('C', ['A','E'])
# graph.add('D', ['B','E', 'F'])
# graph.add('E', ['F', 'B','C', 'D'])
# graph.add('F', ['D','E'])
# Dfs.new(graph, 'A').call

debugger
true





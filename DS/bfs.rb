require 'byebug'
require_relative 'graph_adj_list'
require_relative 'queue'


class Bfs
  attr_reader :graph

  def initialize(graph, start)
    @graph = graph
    @queue = Queue.new
    @visited = Hash.new
    @start = start
  end

  def call
    process_unvisited_node(start)
    until queue.empty?
      v = queue.dequeue
      graph.find_all_adjecent_nodes(v).each do |adj_node|
        process_unvisited_node(adj_node) if node_not_visited?(adj_node)
      end
    end
  end

  private
    attr_reader :queue, :visited, :start

    def push_to_visited(element)
      @visited[element] = true
    end

    def node_not_visited?(element)
      not @visited.key?(element)
    end

    def process_unvisited_node(element)
      puts element
      push_to_visited(element)
      queue.enqueue(element)
    end
end

graph = Graph.new

graph.add(0, [1,2])
graph.add(1, [0,3])
graph.add(2, [0,3,4])
graph.add(3, [1,2,5])
graph.add(4, [2])
graph.add(5, [3])

Bfs.new(graph, 0).call



debugger
true


require "byebug"

class Graph
  attr_accessor :adjecency

  def initialize(arr = [])
    @adjecency = Hash.new([])
    arr.each{|k| @adjecency[k] = []}
  end

  def vertices
    @adjecency.keys
  end

  def add_vertex(value)
    @adjecency[value] = [] unless @adjecency.has_key? value
  end

  def add_edge(v1, v2, weight)
    @adjecency[v1].push Edge.new(v1, v2, weight)
    @adjecency[v2].push Edge.new(v2, v1, weight)
  end

  def rendom_vertex
    vertices.sample
  end

  def adjecents(v)
    adjecency[v]
  end

  private
    attr_accessor :edges
    Edge = Struct.new(:v1, :v2, :weight)
end

# create 2 disjoint sets, 1 for visited nodes/vertices and 1 for non-visited vertices

# Create a priority queue, which stores (or edges ) with weight

# Take a node N, push its adjecents or edges to the priority queue
  # Dequeue edge (containing v1, v2 and weight)
  # Check for cycle - by checking if both nodes are visited?
  # If visisted that means there is a cycle, so skip rest and goto the next itiration
  # In case of not cycel push the remove the node from unvisited set and push it to visited set
  # Push edges from node to the priority queue and go for the next itiration.


class MinSpanningTree

  attr_accessor :visited, :not_visited, :priority_queue, :graph, :weights

  def initialize(graph)
    @visited       = []
    @not_visited   = graph.vertices.clone
    @priority_queue = []
    @graph = graph
    @weights = []
  end

  def process
    vertex = graph.rendom_vertex
    @visited.push(vertex)
    @not_visited.delete(vertex)
    adjecents = graph.adjecents(vertex)
    enqueue(adjecents)

    until @visited.size == graph.vertices.length
      edge = dequeue
      vertex = edge.v2
      # checking cycle
      next if @visited.include? vertex

      @visited.push(vertex)
      @not_visited.delete(vertex)
      @weights.push(edge.weight)
      adjecents = graph.adjecents(vertex)
      enqueue(adjecents)
    end
  end

  def enqueue(item)
    if item.is_a?(Array)
      @priority_queue += item
    else
      @priority_queue.push item
    end
    reprocess_queue
  end

  def dequeue
    raise "Unable to dequeue, Queue is EMPTY" if @priority_queue.length == 0
    @priority_queue.delete_at(0)
  end

  private
    # hack to maintain priority queue
    # Fixme: remove it and add actual priority_queue implementation
    def reprocess_queue
      @priority_queue.sort_by! { |e| e.weight }
    end

end

graph = Graph.new([0,1,2,3])
graph.add_edge 0,1,1
graph.add_edge 0,2,4
graph.add_edge 0,3,3
graph.add_edge 1,3,2
graph.add_edge 2,3,5
graph.weights

# graph.add_edge 0,1,1
# graph.add_edge 0,2,7
# graph.add_edge 1,2,5
# graph.add_edge 1,3,4
# graph.add_edge 1,4,3
# graph.add_edge 2,4,6
# graph.add_edge 3,4,2
# graph.weights


min_tree = MinSpanningTree.new(graph)
min_tree.process
debugger
true





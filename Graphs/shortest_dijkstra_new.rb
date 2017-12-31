# require 'byebug'

class Graph
  Edge = Struct.new(:u,:v,:w)
  attr_accessor :start, :edges

  def initialize
    self.edges = {}
  end

  def vertices
    edges.keys
  end

  def add_edge(u,v,w)
    self.edges[u] ||= []
    self.edges[v] ||= []
    edges[u].push Edge.new(u,v,w)
    edges[v].push Edge.new(v,u,w)
  end
end

graph = Graph.new
# graph.add_edge('A', 'B', 5)
# graph.add_edge('A', 'E', 2)
# graph.add_edge('A', 'D', 7)
# graph.add_edge('B', 'C', 2)
# graph.add_edge('F', 'E', 3)
# graph.add_edge('F', 'D', 2)
# graph.add_edge('D', 'C', 3)
# graph.start = 'A'

graph.add_edge(0,1,4)
graph.add_edge(0,7,8)
graph.add_edge(1,7,11)
graph.add_edge(1,2,8)
graph.add_edge(7,8,7)
graph.add_edge(7,6,1)
graph.add_edge(2,8,2)
graph.add_edge(8,6,6)
graph.add_edge(6,5,2)
graph.add_edge(2,5,4)
graph.add_edge(2,3,7)
graph.add_edge(3,4,9)
graph.add_edge(5,4,10)
graph.add_edge(3,5,14)
graph.start = 0

class DijkstraShortesPath
  attr_accessor :graph, :pque, :visited, :dist

  def initialize(graph)
    self.graph = graph
    self.visited = {}
    self.dist = {}
    self.pque = []
    graph.vertices.each { |e| dist[e] = Float::INFINITY }
    dist[graph.start] = 0
  end

  def calculate_shortest_paths
    add_to_pque(graph.start, 0)
    while visited.length < graph.vertices.length
      u, w = pque.delete_at(0)

      self.visited[u] = true

      graph.edges[u].each do |edge|

        if dist[edge.v] > dist[edge.u] + edge.w
          dist[edge.v] = dist[edge.u] + edge.w
        end
        if visited[edge.v].nil?
          add_to_pque(edge.v, edge.w)
        end
      end
    end
  end

  private
    def add_to_pque(vertex, w)
      self.pque.push [vertex, w]
      self.pque.sort_by! {|arr| arr.last}
    end
end

dj = DijkstraShortesPath.new(graph)
dj.calculate_shortest_paths

puts dj.dist.inspect
# byebug
# true

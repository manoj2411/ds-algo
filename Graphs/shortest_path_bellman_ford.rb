# Used specially when weight can be negative.
#
# In the alos we iterate V-1 time all the edges and checks:
#
# E (u,v,w)
# if distance[u] + w < distance[v] then adjust distance of V
# If we do it n-1 times then this algo ensures the shortest paths to nodes from the starting node N

# After all iterations we need to check for negative cycle in the graph, so
# do 1 more iteration and if distance changes means we have negative cycle otherwise we have soln :)

# Assumption - Graph is directed.

Edge = Struct.new(:u,:v,:weight)
Graph = Struct.new(:vertices, :edges)

class ShortestPath
  attr_accessor :graph, :parent, :distance, :start

  def initialize(graph)
    @graph = graph
    set_parent_and_distance
    @start = graph.vertices.first
    @distance[@start] = 0
  end


  def apply_bellman_ford
    (graph.vertices.length - 1).times do
      graph.edges.each do |edge|
        if distance[edge.u] + edge.weight < distance[edge.v]
          distance[edge.v] = distance[edge.u] + edge.weight
          parent[edge.v] = edge.u
        end
      end
    end

    # Check for negative cycle
      graph.edges.each do |edge|
        if distance[edge.u] + edge.weight < distance[edge.v]
          raise 'Negative Cycle'
        end
      end

    puts "Distance: #{distance}"
  end

  private

    def set_parent_and_distance
      @parent = {}
      @distance = {}
      graph.vertices.map do |v|
        @parent[v] = v
        @distance[v] = Float::INFINITY
      end
    end

end

vertices = ('a'..'e').to_a
edges = [
  Edge.new('a','b',-1),
  Edge.new('a','c',4),
  Edge.new('b', 'c', 3),
  Edge.new('b', 'd', 2),
  Edge.new('b', 'e', 2),
  Edge.new('e', 'd', -3),
  Edge.new('d', 'b', 1),
  Edge.new('d', 'c', 5)]
graph = Graph.new(vertices, edges)

ShortestPath.new(graph).apply_bellman_ford
# => Distance: {"a"=>0, "b"=>-1, "c"=>2, "d"=>-2, "e"=>1}

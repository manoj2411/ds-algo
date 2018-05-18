# Simplified implementation

class Graph
  attr_reader :mappings

  def initialize
    @mappings = {}
  end

  def add_edge(u, v, weight)
    @mappings[u] ||= []
    @mappings[v] ||= []
    @mappings[u] << {v: v, weight: weight}
    @mappings[v] << {v: u, weight: weight}
  end

  def related_nodes(node)
    if @mappings[node]
      return @mappings[node]
    else
      puts ":- #{node}"
    end
  end

  def vertices
    @mappings.keys
  end
end

class ShortestPath

  attr_reader :start, :distance, :not_visited, :graph

  def initialize(graph, start)
    @graph = graph
    @distance = {}
    @not_visited = {}
    @start = start
  end

  def djkstra
    vertices = graph.vertices
    vertices.each do |vertex|
      @distance[vertex] = Float::INFINITY
      @not_visited[vertex] = nil
    end
    @distance[start] = 0

    while !not_visited.empty?
      vertex = get_min
      weight = distance[vertex]

      graph.related_nodes(vertex).each do |vertex2|
        if not_visited.key?(vertex2[:v]) && (weight + vertex2[:weight]) < distance[vertex2[:v]]
          distance[vertex2[:v]] = (weight + vertex2[:weight])
        end
      end
    end
  end

  def get_min
    min = Float::INFINITY
    vertex = nil

    distance.each_pair do |ver, weight|
      if not_visited.key?(ver) && weight < min
        min = weight
        vertex = ver
      end
    end
    not_visited.delete(vertex)
    return vertex
  end

end

graph = Graph.new
graph.add_edge 'a', 'b', 5
graph.add_edge 'a', 'd', 9
graph.add_edge 'a', 'e', 2
graph.add_edge 'b', 'c', 2
graph.add_edge 'd', 'c', 3
graph.add_edge 'd', 'f', 2
graph.add_edge 'f', 'e', 3

sp = ShortestPath.new(graph, 'a')
sp.djkstra
puts sp.distance.to_s

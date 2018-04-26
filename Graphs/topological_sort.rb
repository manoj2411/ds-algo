class Graph
  attr_reader :mapping

  def initialize
    @mapping = {}
  end

  def add_edge(u, v)
    mapping[u] ||= []
    mapping[u] << v
  end

  def vertices
    mapping.keys.shuffle
  end

  def related_vertices(node)
    mapping[node] || []
  end

  def length
    vertices.length
  end
end

def sort_helper(vertex, graph, visited, stack)
  visited[vertex] = true
  graph.related_vertices(vertex).each do |related_vertex|
    if visited[related_vertex] == nil
      sort_helper( related_vertex, graph, visited, stack)
    end
  end
  stack.push(vertex)
end

def topological_sort(graph)
  stack = []
  visited = Array.new(graph.length)
  graph.vertices.each do |vertex|
    if visited[vertex] == nil
      sort_helper(vertex, graph, visited, stack)
    end
  end
  while not stack.empty?
    print stack.pop
    print ' '
  end
  puts
end

graph = Graph.new
graph.add_edge 5, 2
graph.add_edge 5, 0
graph.add_edge 4, 0
graph.add_edge 4, 1
graph.add_edge 2, 3
graph.add_edge 3, 1

topological_sort(graph)

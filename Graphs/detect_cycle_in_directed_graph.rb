class Graph
  attr_reader :matrix
  def initialize(size)
    @matrix = Array.new(size) { Array.new(size, 0)}
  end

  def add_edge(u,v)
    matrix[u][v] = 1
  end

  def print
    matrix.each {|row| puts row.join(', ')}
  end

  def has_cycle?
    visited = Array.new(matrix.size, false)
    in_stack = Array.new(matrix.size, false)

    for i in 0...matrix.length
      if visited[i] == false
        if has_cycle_helper?(i, visited, in_stack)
          return true
        end
      end
    end
    return false
  end

  def related_vertices(v)
    vertices = []
    matrix[v].each_with_index do |value, indx|
      vertices << indx if value == 1
    end
    return vertices
  end

  private
    def has_cycle_helper?(v, visited, in_stack)
      visited[v] = true
      in_stack[v] = true
      related_vertices(v).each do |rel_vertex|
        if in_stack[rel_vertex] || has_cycle_helper?(rel_vertex, visited, in_stack)
          return true
        end
      end
      in_stack[v] = false
      return false
    end

end

### Tests

# graph = Graph.new(4)
# graph.add_edge(0,1)
# graph.add_edge(0,2)
# graph.add_edge(1,2)
# # graph.add_edge(2,0)
# graph.add_edge(2,3)
# # graph.add_edge(3,3)

# graph = Graph.new(3)
# graph.add_edge 2,2

# graph = Graph.new(2)
# graph.add_edge 0, 1
# graph.add_edge 0, 1

graph = Graph.new(4)
graph.add_edge 0, 1
graph.add_edge 0, 2
graph.add_edge 1, 2
graph.add_edge 1, 3
graph.add_edge 2, 3

puts "Cycle detected? - #{graph.has_cycle?}"

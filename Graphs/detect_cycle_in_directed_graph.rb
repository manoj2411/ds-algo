require "pry"

class Graph
  attr_reader :vertices

  def initialize(size)
    @vertices = {}
    build_vertices(size)
  end

  def add_edge(u,v)
    @vertices[u] << v
  end

  def relate_vertices(vertex)
    @vertices[vertex]
  end

  def has_cycle?
    visited = Array.new @vertices.keys.length
    in_stack = Array.new @vertices.keys.length

    @vertices.keys.each do |vertex|
      next if visited[vertex] || in_stack[vertex]

      # initialize stack, base data
      stack = [vertex]
      in_stack[stack.last] = true
      while not stack.empty?
        curr_vertex = stack.pop
        visited[curr_vertex] = true
        in_stack[curr_vertex] = false
        relate_vertices(curr_vertex).each do |related_vertex|
          if visited[related_vertex] || in_stack[related_vertex]
            return true
          end
          stack << related_vertex
          in_stack[related_vertex] = true
        end
      end
    end

    return false
  end

  private
    def build_vertices(size)
      size.times {|i| @vertices[i] = []}
    end
end

### Tests

# graph = Graph.new(4)
# graph.add_edge(0,1)
# graph.add_edge(0,2)
# graph.add_edge(1,2)
# graph.add_edge(2,0)
# graph.add_edge(2,3)
# graph.add_edge(3,3)

# graph = Graph.new(3)
# graph.add_edge 2,2

# graph = Graph.new(2)
# graph.add_edge 0, 1
# graph.add_edge 0, 1

graph = Graph.new(4)
graph.add_edge 0, 1
graph.add_edge 1, 2
graph.add_edge 2, 3

puts "Cycle detected? - #{graph.has_cycle?}"

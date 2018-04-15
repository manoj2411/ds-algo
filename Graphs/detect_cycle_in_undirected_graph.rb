class Graph

  attr_accessor :matrix, :size

  def initialize(length)
    @size = length
    @matrix = Array.new(length) { Array.new(length, 0) }
  end

  def add_edge(u, v)
    @matrix[u][v] = 1
    @matrix[v][u] = 1
  end

  def has_cycle?
    visited = Array.new(size, false)

    for i in 0...size
      unless visited[i]
        if cycle_helper(i, visited, -1)
          return true
        end
      end
    end
    return false
  end

  def related_vertices(v)
    res = []
    matrix[v].each_with_index {|val, indx| res.push(indx) if val == 1 }
    res
  end

  private
    def cycle_helper(v, visited, parent)
      visited[v] = true
      # binding.pry
      related_vertices(v).each do |u|
        if visited[u] && u != parent || (!visited[u] && cycle_helper(u, visited, v))
          # puts [u, visited, parent].to_s
          # puts "--2"
          return true
        end
      end
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
# graph.add_edge 0, 2
graph.add_edge 1, 2
graph.add_edge 3, 1
# graph.add_edge 2, 3

puts "Cycle detected? - #{graph.has_cycle?}"

# Find shortest distances between every pair of vertices of weighted directed Graph
#
INF = Float::INFINITY

class FloydWarshall

  def self.apply(graph)
    return [] if graph.empty?
    v = graph.length

    sol = Array.new(v) { Array.new(v)}
    for i in 0...v
        for j in 0...v
            sol[i][j] = graph[i][j]
        end
    end

    for k in 0...v
        for i in 0...v
            for j in 0...v
                sol[i][j] = sol[i][k] + sol[k][j] if sol[i][j] > sol[i][k] + sol[k][j]
            end
        end
    end
    sol
  end

end


graph = [
  [0, 5, INF, 10],
  [INF, 0, 3, INF],
  [INF, INF, 0, 1],
  [INF, INF, INF, 0]]

result = FloydWarshall.apply(graph)

result.each {|r| puts r.map{|e| e == INF ? 'Inf' : e }.join("\t") }
# Shortest distance matrix
    #   0      5      8      9
    # INF      0      3      4
    # INF    INF      0      1
    # INF    INF    INF      0

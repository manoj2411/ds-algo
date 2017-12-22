require "byebug"
INF = Float::INFINITY

class FloydWarshall

  attr_accessor :graph, :distance

  def initialize(graph)
    self.graph = graph
    self.distance = []
  end

  def process
    graph.each do |arr|
      _inner_arr = []
      arr.each {|e| _inner_arr.push e}
      distance.push(_inner_arr)
    end

    length = graph.length - 1

    0.upto(length) do |k|
      0.upto(length) do |i|
        0.upto(length) do |j|
          if distance[i][j] > distance[i][k] + distance[k][j]
            distance[i][j] = distance[i][k] + distance[k][j]
          end
        end
      end
    end

    print_result
  end

  def print_result
    distance.each do |arr|
      puts arr.join(", ")
    end
  end
end


graph = [
  [0, 5, INF, 10],
  [INF, 0, 3, INF],
  [INF, INF, 0, 1],
  [INF, INF, INF, 0]]

FloydWarshall.new(graph).process


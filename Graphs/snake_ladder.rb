Vertex = Struct.new(:position, :moves)

def quickestWayUp(ladders, snakes)
  ladders_snakes = Hash[ladders + snakes]
  visited = Array.new(101, false)
  que = Queue.new
  que.enq Vertex.new(1,0)
  visited[1] = true

  while (not que.empty?)
    vertex = que.deq
    return vertex.moves if vertex.position == 100

    for i in 1..6
      position = ladders_snakes[vertex.position + i] ? ladders_snakes[vertex.position + i] : vertex.position + i
      next if position > 100 || visited[position]
      que.enq Vertex.new(position, vertex.moves + 1)
      visited[position] = true
    end
  end
  -1
end

ladders = [ [32,62], [42,68], [12,98] ]
snakes = [ [95,13], [97,25], [93,37], [79,27], [75,19], [49,47], [67,17]]

result = quickestWayUp ladders, snakes

puts result

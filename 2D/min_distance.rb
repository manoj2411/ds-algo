=begin
  Find min distance to reach the destination from source on a 2D matrix.
   - soruce is always top left i.e. 0,0
   - 9 represents destination
   - 1 represnets valid path to go
   - 0 represents wall or trench, path is blocked here

  If we reach the destination successfully then returns the distance otherwise return -1
=end

def valid_next_steps(rows, cols, matrix, i, j)
  next_steps = []

  # check right
  right = j + 1
  next_steps << [i, right] if right < cols && matrix[i][right] > 0

  # check down
  down = i + 1
  next_steps << [down, j] if down < rows && matrix[down][j] > 0

  # check left
  left = j - 1
  next_steps << [i, left] if left >= 0 && matrix[i][left] > 0

  # check up
  up = i - 1
  next_steps << [up, j] if up >= 0 && matrix[up][j] > 0

  next_steps
end

def find_min_disntace(rows, cols, matrix)
  que = Queue.new
  que << [0,0]
  distance = 0

  while !que.empty?
    distance += 1
    next_queue = Queue.new

    while !que.empty?
      i,j = que.deq
      matrix[i][j] = -1 # mark visited

      valid_next_steps(rows, cols, matrix, i, j).each do |pair|
        row, col = pair
        return distance if matrix[row][col] == 9
        next_queue << pair
      end

    end
    que = next_queue
  end

  -1
end


[
  [3,3, [[1,0,0], [1,0,0], [1,9,1]], 3],
  [3,3, [[1,0,0], [1,0,0], [0,9,1]], -1],
  [3,3, [[1,1,1], [1,0,1], [0,9,1]], 5],
  [5,4, [[1,1,1,1], [0,1,1,1], [0,1,0,1],[1,1,9,1],[0,0,1,1]], 5],
  [5,4, [[1,1,1,1], [0,1,1,1], [0,0,0,1],[1,1,9,1],[0,0,1,1]], 7],
  [5,4, [[1,1,1,1], [0,1,1,1], [0,0,1,1],[1,1,9,1],[0,0,1,1]], 5]
].each do |rows, cols, matrix, expected|
  matrix.each { |e| puts e.to_s}
  result = find_min_disntace(rows, cols, matrix)
  puts "Test passed:#{result == expected} expected #{expected} got #{result}"
  puts
end

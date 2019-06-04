def find_start(matrix)
  matrix.each_with_index do |_, i|
    matrix[i].each_with_index do |k, j|
      return [i,j] if k == 1
    end
  end
  return [-1, -1]
end

def find_valid_neighbours(i, j, matrix, visited, rl, cl)
  possible_neighbours = [
    [i + 1, j],
    [i - 1, j],
    [i, j + 1],
    [i, j - 1]
  ]
  possible_neighbours.select do |pair|
    _i, _j = pair

    (0...rl).include?(_i) and
    (0...cl).include?(_j) and
    (not visited[_i][_j]) and
    matrix[_i][_j] != 0
  end
end

def path_exists?(m)
  row_length = m.length
  col_length = m.first.length # assuming valid matrix is passed with some elements

  i, j = find_start(m)
  return false if i< 0 || j < 0

  visited = Array.new(row_length) { Array.new(col_length, false) }

  stack = []
  stack.push([i, j])

  while (!stack.empty?)
    i, j = stack.pop
    # return if find the destination
    return true if m[i][j] == 2

    neighbours = find_valid_neighbours(i, j, m, visited, row_length, col_length)
    neighbours.each {|e| stack.push e }
    visited[i][j] = true
  end
  return false
end


def pp(mat)
  mat.each do |row|
    puts row.to_s
  end
end

matrix = [
  [ 0 , 3 , 0 , 1],
  [ 3 , 0 , 3 , 3],
  [ 2 , 3 , 3 , 3],
  [ 0 , 3 , 3 , 3]
]
pp matrix
puts path_exists?(matrix)

# rl = matrix.length
# cl = matrix.first.length
# visited = Array.new(rl) { Array.new(cl, false) }

# puts find_valid_neighbours(0, 3, matrix, visited, rl, cl)

matrix = [
  [3,0,0,0],
  [0,3,3,0],
  [0,1,0,3],
  [0,2,3,3 ]
]
pp matrix
puts path_exists?(matrix)

matrix = [
  [0,3,2],
  [3,0,0],
  [1,0,0]
]
pp matrix
puts path_exists?(matrix)

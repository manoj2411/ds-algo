DELIMETER = [-1, -1]

def root_all_oranges(matrix, m, n)
  que = []

  # fill in initial rottened oranges

  for i in 0...m
    for j in 0...n
      if matrix[i][j] == 2
        que.push([i, j])
      end
    end
  end

  que.push(DELIMETER)
  flag = false
  result = 0

  while not que.empty?
    cell = que.shift

    if cell == DELIMETER
      flag = false
      if not que.empty?
        que.push DELIMETER
      end
      next
    end

    row, col = *cell
    # check top
    if row - 1 >= 0 && matrix[row - 1][col] == 1
      if flag == false
        flag = true
        result += 1
      end
      matrix[row - 1][col] = 2
      que.push([row - 1, col])
    end

    # check right
    if col + 1 < n && matrix[row][col + 1] == 1
      if flag == false
        flag = true
        result += 1
      end
      matrix[row][col + 1] = 2
      que.push([row, col + 1])
    end

    # check left
    if col - 1 >= 0 && matrix[row][col - 1] == 1
      if flag == false
        flag = true
        result += 1
      end
      matrix[row][col - 1] = 2
      que.push [row, col - 1]
    end

    # check bottom
    if row + 1 < m && matrix[row + 1][col] == 1
      if flag == false
        flag = true
        result += 1
      end
      matrix[row + 1][col] = 2
      que.push [row + 1, col]
    end
  end

  return fresh_oranges_exists?(matrix, m, n) ? -1 : result

end

def fresh_oranges_exists?(matrix, m, n)
  for i in 0...m
    for j in 0...n
      if matrix[i][j] == 1
        return true
      end
    end
  end
  return false
end

def pp(matrix)
  matrix.each do |row|
    puts row.to_s
  end
end

m,n = 3,5
matrix = [
  [2,1,0,2,1],
  [1,0,1,2,1],
  [1,0,0,2,1]]

puts "Matrix"
pp matrix
puts "Result: #{root_all_oranges(matrix, m, n)}"
puts

m,n = 3,5
matrix = [
  [2,1,0,2,1],
  [0,0,1,2,1],
  [1,0,0,2,1]
]
puts "Matrix"
pp matrix
puts "Result: #{root_all_oranges(matrix, m, n)}"


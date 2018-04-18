def solve_n_queen(n)
  if n <= 0
    puts 'No Solution'
    return
  end

  matrix = Array.new(n) { Array.new(n, 0) }
  result = []
  n_queen(matrix, result, 0, n)
  if result.empty?
    puts 'No Solution'
  # else
  #   result.each do |row|
  #     puts row.to_s
  #   end
  end
end

def pp(matrix)
  puts
  matrix.each do |row|
    puts row.to_s
  end
end

def push_result(matrix, result, n)
  arr = []
  for i in 0...n
    for j in 0...n
      if matrix[i][j] == 1
        arr[i] = j
        break
      end
    end
  end
  result.push arr
end

def n_queen(matrix, result, row, n)
  if row >= n
    pp matrix
    push_result matrix, result, n
    return
  end

  for i in 0...n
    if safe?(matrix, row, i, n)
      matrix[row][i] = 1
      n_queen(matrix, result, row + 1, n)
      matrix[row][i] = 0
    end
  end
end

def safe?(matrix, row, i, n)
  return false if not safe_column_wise?(matrix, row, i)
  return false if not safe_left_diagonally?(matrix, row, i)
  return safe_right_diagonally?(matrix, row, i, n)
end

def safe_right_diagonally?(matrix, row, col, max)
  r = row - 1
  c = col + 1
  while row >= 0 and c < max
    if matrix[r][c] == 1
      return false
    end
    r -= 1
    c += 1
  end
  return true
end

def safe_left_diagonally?(matrix, row, col)
  r = row - 1
  c = col - 1
  while r >= 0 and c >= 0
    if matrix[r][c] == 1
      return false
    end
    r -= 1
    c -= 1
  end
  return true
end

def safe_column_wise?(matrix, row, col)
  r = row - 1
  while r >= 0
    if matrix[r][col] == 1
      return false
    end
    r -= 1
  end
  return true
end


[0,1,2,3,4, 5,6].each do |n|
  puts "N queen for:#{n}"
  solve_n_queen(n)
  puts
  puts '---' * 50
  puts
end

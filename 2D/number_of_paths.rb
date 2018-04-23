def no_of_paths(m, n)
  result = [0]
  helper(result, 0, 0, m, n)
  return result[0]
end

def helper(result, row, col, m, n)
  return if row >= m || col >= n

  if row == m - 1 && col = n - 1
    result[0] += 1
    return
  end

  # explore right
  helper(result, row, col + 1, m, n)
  # explore down
  helper(result, row + 1, col, m, n)
end

puts "3 X 3 - #{no_of_paths(3, 3)}"
puts "2 X 8 - #{no_of_paths(2, 8)}"

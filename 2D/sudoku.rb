def solve_sudoku(matrix)
  cell = find_next_empty_space(matrix)
  if cell.empty?
    return true
  end

  i, j = *cell

  for x in 1..9
    if is_safe?(matrix, i, j, x)
      # choose
      matrix[i][j] = x
      # explore
      if solve_sudoku(matrix)
        return true
      end
      # unchoose
      matrix[i][j] = 0
    end
  end
  return false
end

def find_next_empty_space(matrix)
  for i in 0...9
    for j in 0...9
      return [i,j] if matrix[i][j] == 0
    end
  end
  return []
end

def is_safe?(matrix, r, c, x)
  # check row
  for i in 0..8
    if matrix[i][c] == x
      return false
    end
  end
  # check column
  for i in 0..8
    if matrix[r][i] == x
      return false
    end
  end

  # check box
  # 0,1,2 = 0
  # 3,4,5 = 3
  # 6,7,8 = 6
  row_i = (r / 3) * 3
  col_i = (c / 3) * 3
  for i in row_i..(row_i + 2)
    for j in col_i..(col_i + 2)
      if matrix[i][j] == x
        return false
      end
    end
  end

  return true
end

arr = [
[3, 0, 6, 5, 0, 8, 4, 0, 0],
[5, 2, 0, 0, 0, 0, 0, 0, 0],
[0, 8, 7, 0, 0, 0, 0, 3, 1],
[0, 0, 3, 0, 1, 0, 0, 8, 0],
[9, 0, 0, 8, 6, 3, 0, 0, 5],
[0, 5, 0, 0, 9, 0, 6, 0, 0],
[1, 3, 0, 0, 0, 0, 2, 5, 0],
[0, 0, 0, 0, 0, 0, 0, 7, 4],
[0, 0, 5, 2, 0, 6, 3, 0, 0]]

res = solve_sudoku(arr)

for lst in arr
  puts lst.to_s
end

puts "res: #{res}"


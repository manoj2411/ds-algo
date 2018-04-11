def solve_sudoku(m)
  i, j = find_next_empty_space(m)
  if i.nil?
    return true
  end

  for x in 1..9
    if is_safe?(m, i, j, x)
      m[i][j] = x
      if solve_sudoku(m)
        return true
      end
      m[i][j] = 0
    end
  end
  return false
end

def find_next_empty_space(m)
  for i in 0...9
    for j in 0...9
      return i,j if m[i][j] == 0
    end
  end
  return
end

def is_safe?(m, i, j, num)
  for k in 0...9
    if m[i][k] == num || m[k][j] == num
      return false
    end
  end
  x = (i / 3) * 3
  y = (j / 3) * 3

  for k in x..(x + 2)
    for l in y..(y + 2)
      return false if m[k][l] == num
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


def find_number_of_islands(matrix, rows, cols)
  visited = Array.new(rows) { Array.new(cols, false) }
  count = 0

  for i in 0...rows
    for j in 0...cols
      if matrix[i][j] == 1 && visited[i][j] == false
        visit_dfs(matrix, rows, cols, visited, i, j)
        count += 1
      end
    end
  end
  return count
end

def visit_dfs(matrix, rows, cols, visited, r, c)
  visited[r][c] = true
  related_cells(matrix, rows, cols, r, c).each do |cell|
    i, j = *cell
    if matrix[i][j] == 1 && visited[i][j] == false
      visit_dfs(matrix, rows, cols, visited, i, j)
    end
  end
end

def related_cells(matrix, rows, cols, r, c)
  result = []
  # left - [0, -1]
  # right - [0, 1]
  # top - [-1, 0]
  # bottom - [1, 0]
  # top-left - [-1, -1]
  # top-right - [-1, 1]
  # bottom-left - [1, -1]
  # bottom-right - [1, 1]
  [
    [0, -1], [0, 1], [-1, 0], [1, 0], [-1, -1], [-1, 1], [1, -1], [1, 1]
  ].each do |cell|
    i = r + cell[0]
    j = c + cell[1]
    if (0...rows).cover?(i) && (0...cols).cover?(j)
      result.push [i,j]
    end
  end
  return result
end

def pp(matrix)
  matrix.each {|row| puts row.to_s }
end

matrix = [[1,1,0],[0,0,1],[1,0,1]]
cols = rows = 3
puts "Matrix:"
pp matrix
puts "Islands: #{find_number_of_islands matrix, rows, cols}"
puts

matrix = [
  [1, 1, 0, 0, 0],
  [0, 1, 0, 0, 1],
  [1, 0, 0, 1, 1],
  [0, 0, 0, 0, 0],
  [1, 0, 1, 0, 1]
]
cols = rows = 5
puts "Matrix:"
pp matrix
puts "Islands: #{find_number_of_islands matrix, rows, cols}"

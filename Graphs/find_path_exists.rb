def find_source(matrix, n)
  for i in 0...n
    for j in 0..n
      if matrix[i][j] == 1
        return i, j
      end
    end
  end
  raise 'No starting point'
end

def path_exists?(matrix, n)
  # find source
  i, j = find_source(matrix, n)
  visited = Array.new(n) { Array.new(n, false)}
  # call DFS util to reach destination (matrix, i, j)
  return dfs_helper(matrix, i, j, visited, n)

end

def dfs_helper(matrix, i, j, visited, n)
  # base condition
  return true if matrix[i][j] == 2
  # mark curr node as visited
  visited[i][j] = true

  # puts "i, j - #{i}, #{j} \t #{neighbours(matrix, i, j, n)}"

  # find neighbours of curr node and traverse 1 by 1
  neighbours(matrix, i, j, n).each do |pair|
    row, col = *pair
    next if matrix[row][col] == 0 # wall
    # if reach to destination return true
    if visited[row][col] == false && dfs_helper(matrix, row, col, visited, n)
      return true
    end
  end
  return false
end

def neighbours(matrix, i, j, n)
  result =[]
  # check up
  result << [i - 1, j] if i > 0
  # check down
  result << [i + 1, j] if i + 1 < n
  # check left
  result << [i, j - 1] if j > 0
  # check right
  result << [i, j + 1] if j + 1 < n
  return result
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
puts path_exists?(matrix, 4)

matrix = [
  [3,0,0,0],
  [0,3,3,0],
  [0,1,0,3],
  [0,2,3,3 ]
]
pp matrix
puts path_exists?(matrix, 4)

matrix = [
  [0,3,2],
  [3,0,0],
  [1,0,0]
]
pp matrix
puts path_exists?(matrix, 3)

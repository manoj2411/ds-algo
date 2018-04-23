def number_of_paths(m, n)
  # initialize paths matrix, it'll keep track the number of possible paths
  # to a cell from top left cell i.e. 0, 0
  paths = Array.new(m) { Array.new(n) }

  # there will be only 1 way we can go when we move straight and down, so adding
  # this initial case in the matrix
  for i in 0...m
    paths[i][0] = 1
  end
  for i in 0...n
    paths[0][i] = 1
  end

  for i in 1...m
    for j in 1...n
      # paths[i][j] = no of ways I can reach to above cell +
      #               no of ways I can reach to left cell
      paths[i][j] = paths[i - 1][j] + paths[i][j - 1]
    end
  end

  return paths[m - 1][n - 1]
end


puts "3 X 3 - #{number_of_paths(3, 3)}"
puts "2 X 8 - #{number_of_paths(2, 8)}"


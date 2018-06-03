def get_water_info(k, r, c)

  m = Array.new((k / 2) + 1) { Array.new((k / 2) + 1, 0) }

  m[0][0] = k

  for i in 0..(k / 2)
    for j in 0..i
      rem = m[i][j] - 1
      next if rem <= 0
      m[i][j] = 1
      m[i + 1][j] += rem / 2.0
      m[i + 1][j + 1] += rem / 2.0
    end
  end

  return m[r - 1][c - 1]
end


for input in [[3,2,1], [2, 2, 2], [7, 4, 1], [7, 4, 2], [7, 4, 3], [7, 4, 4], [33, 7, 3]]
  puts "Input: #{input}"
  puts "Output: #{get_water_info( *input )}"
end

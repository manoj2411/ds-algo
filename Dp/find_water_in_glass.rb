def water_overflow(k, i, j)
  len =  i * (i + 1) / 2
  # len =  (k / 2) + 1
  mat = Array.new(len) { Array.new(len, 0) }

  mat[0][0] = k

  for line in 0...(len - 1)
    for col in 0..(line)
      next if mat[line][col] <= 1
      remaining = mat[line][col] - 1
      mat[line][col] = 1
      mat[line + 1][col] += (remaining / 2.0)
      mat[line + 1][col + 1] += (remaining / 2.0)
    end
  end
  # pp mat

  return mat[i - 1][j - 1] > 1 ? 1 : mat[i - 1][j - 1]
end

def pp(mat)
  mat.each {|row| puts row.to_s }
end

puts water_overflow(2,2,2)
puts water_overflow(8,4,2)

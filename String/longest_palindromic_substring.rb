def print_matrix(matrix)
  matrix.each do |row|
    puts row.join("\t")
  end
end

def longest_palindrom(str)
  length = str.length
  matrix = Array.new(length) { |i| Array.new(length, false) }

  max_length = 1
  start = last = 0

  1.upto(length) do |window_size|
    0.upto(length - window_size) do |i|
      j = i + window_size - 1

      if is_palindrom?(str, i,j,matrix, length)
        if max_length <  window_size
          max_length = window_size
          start = i
          last = j
        end
        matrix[i][j] = 1
      end
    end
  end
  # print_matrix matrix
  str[start..last]
end

def is_palindrom?(str, i, j, matrix, length)
  if i == j
    return true
  else
    if str[i] == str[j]
      if j - i > 1 && matrix[i + 1][j - 1] != 1
        return false
      end
      return true
    end
    return false
  end
end

['aaba', 'forgeeksaskeegfor', 'aaaabbaa'].each do |str|
  puts "String: #{str} - #{longest_palindrom(str)}"
  # {longest_palindrom(str)}"
end

# brute force
def bf_longest_palindrom(str)
  return 0 if str.empty?
  result = 1
  left = 0
  right = 0
  length = str.length

  0.upto(length - 1) do |i|
    (i + 1).upto(length - 1) do |j|
      if palindrom_substring?(str, i,j)
        if j - i > result
          result = j - i
          left = i
          right = j
        end
      end
    end
  end
  return str[left..right]
end

# brute force
def bf_palindrom_substring?(str, i,j)
  while j > i
    return false if str[i] != str[j]
    j -= 1
    i += 1
  end
  return true
end

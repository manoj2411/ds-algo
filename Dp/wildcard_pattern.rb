require 'pry'
def pattern_matched?(str, pattern)
  len_s = str.length
  len_p = pattern.length

  # size is +1 because we need to consider empty string case
  matrix = Array.new(len_s + 1) { Array.new(len_p + 1)}

  # it'll be a match when both string and pattern is empty
  matrix[0][0] = true

  # setup first col, for empty pattern string
  for i in 1..len_s
    matrix[i][0] = false
  end

  # setup first row, check for empty string,
  # it'll be true only when pattern is empty or it starts with
  for i in 1..len_p
    if pattern[i - 1] == '*'
      if i == 1
        matrix[0][i] = true
      else
        matrix[0][i] = matrix[0][i - 2] || matrix[0][i - 1]
      end
    else
      matrix[0][i] = false
    end
  end

  for i in 1..len_s
    # len_s is max row number
    # len_p is max col number
    for j in 1..len_p
      if str[i - 1] == pattern[j - 1] || pattern[j - 1] == '?'
        matrix[i][j] = matrix[i - 1][j - 1]
      elsif pattern[j - 1] == '*'
        # 2 cases now:
        #   1. ignore char before '*' and assume its 0 occurance
        #   2. if str[i - 1] == pattern[j - 2] (or pattern[j - 2] is '?', any character)
        #       then assume str[i - 1] part of pattern and check result
        #       ignoring str[i - 1]
        if matrix[i][j - 2] ||
          ((str[i - 1] == pattern[j - 2] || pattern[j - 2] == '?' ) && matrix[i - 1][j])
          matrix[i][j] = true
        else
          matrix[i][j] = false
        end
      else
        matrix[i][j] = false
      end
    end
  end

  # puts "Matrix:"
  # matrix.each {|row| puts row.join("\t")}

  for i in 0..len_s
    if matrix[i][len_p]
      return true
    end
  end

  return false
end

str = 'baaabab'
# pattern = "*****ba*****ab" # true
# pattern = "baaa?ab" # true
# pattern = "ba*a?" # true
# pattern = "a*ab" # false
# pattern = '*baaaba*' # true
# pattern = '?baaabab' # false
# pattern = 'baaabab' #yes
# pattern = 'a*a' # no
# pattern = 'b*b' # yes
pattern = 'aa?ab' # no
# pattern = '****'
# pattern = 'ba*ab****'
# pattern = '*a*****ab'
puts "Str: #{str} \nPattern: #{pattern}"
puts pattern_matched?(str, pattern)



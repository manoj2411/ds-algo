def min_chars_required(str)
  n = str.length
  # Initialize solution cache matrix
  matrix = Array.new(n) { Array.new(n, 0) }

  # loop through size 1 to n - 1 and fill in result matrix
  for k in 1...n
    # start of string for every k
    l = 0
    # last char of string for k
    r = k

    while r < n
      if str[l] == str[r]
        # since start and end chars of string are same, we can keep inner string result
        # as resut of it i.e. length required to form a palindrome for inner string
        #
        matrix[l][r] = matrix[l + 1][r - 1]
      else
        matrix[l][r] = [matrix[l + 1][r], matrix[l][r - 1]].min + 1
      end
      r += 1
      l += 1
    end
  end
  return matrix[0][n - 1]
end

['abbd', 'aa', 'a', 'aab', 'aba', 'ab', 'abcd', 'geeks'].each do |str|
  puts "\nStr: #{str}\nMin chars required to form a Palindrome: #{min_chars_required(str)}"
end

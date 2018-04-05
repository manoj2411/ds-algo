def longest_common_substring(str1, str2)

  result = 0

  matrix = Array.new(str1.length) { Array.new(str2.length) }

  for i in 0...str1.length
    for j in 0...str2.length
      if str1[i] == str2[j]
        if i == 0 || j == 0
          matrix[i][j] = 1
        else
          matrix[i][j] = matrix[i - 1][j - 1] + 1
        end
        result = matrix[i][j] if matrix[i][j] > result
      else
        matrix[i][j] = 0
      end
    end
  end

  return result
end

[
  ['GeeksforGeeks', 'GeeksQuiz'], ['abcdxyz', 'xyzabcd'], ['zxabcdezy', 'yzabcdezx'],
  %w{ABCDGH ACDGHR}, %w{ABC AC}
].each do |arr|
  puts "Str1: #{arr[0]}\nStr2: #{arr[1]}\nLCS: #{longest_common_substring(*arr)}\n\n"
end



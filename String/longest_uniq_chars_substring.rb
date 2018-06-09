def longest_distinct_chars(string)
  curr_len = max_len = 0
  hs = {}
  left = 0

  for r in 0...string.length
    char = string[r]

    if hs.key?(char) && r - hs[char] <= curr_len
      curr_len = r - hs[char]
    else
      curr_len += 1
      max_len = curr_len if curr_len > max_len
    end
    hs[char] = r
  end

  return max_len
end


['abababcdefababcdab', 'geeksforgeeks', 'BBBB', 'ABDEFGABEF'].each do |str|
  puts "Str:#{str}\nLDCS: #{longest_distinct_chars(str)}\n"
end

def longest_palindrom(str)
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


def palindrom_substring?(str, i,j)
  while j > i
    return false if str[i] != str[j]
    j -= 1
    i += 1
  end
  return true
end

['forgeeksskeegfor', 'aaaabbaa'].each do |str|
  puts "String: #{str} - #{longest_palindrom(str)}"
end

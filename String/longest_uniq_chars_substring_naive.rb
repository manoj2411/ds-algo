# O(n^3) solution
def get_uniq_chars_substr_count(str, l, r)
  count = 0

  while l <= r
    r.downto(l) do |j|
      next if r == j
      if  str[r] == str[j]
        l = j + 1
        break
      end
    end
    count += 1
    r -= 1
  end
  return count
end

def longest_substr_length(str)
  result = 0
  for i in 1...str.length
    count = get_uniq_chars_substr_count(str, 0, i)
    result = count if result < count
  end
  return result
end


for str in ['geeksforgeeks', 'geeks', 'manoj', 'abababcdefababcdab', 'BBBB', 'ABDEFGABEF']
  puts "Input: #{str} \nOutput: #{longest_substr_length str}"
end

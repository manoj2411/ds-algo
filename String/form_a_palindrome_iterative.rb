def min_chars_required(str)
  return -1 if str.empty?

  l = 0
  r = str.length - 1
  return helper(str, l, r)
end

def helper(str, l, r)
  if l == r
    return 0
  elsif l +1 == r
    return str[l] == str[r] ? 0 : 1
  elsif str[l] == str[r]
    return helper(str, l + 1, r - 1)
  else
    return [helper(str, l + 1, r), helper(str, l, r - 1)].min + 1
  end
end


['abbd', 'aa', 'a', 'aab', 'aba', 'ab', 'abcd', 'geeks'].each do |str|
  puts "\nStr: #{str}\nMin chars required to form a Palindrome: #{min_chars_required(str)}"
end

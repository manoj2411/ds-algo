def remove_adjecent_duplicates(str)
  len = str.length
  new_str = ""
  i = 0
  j = -1

  while i < len
    if new_str[j] == str[i]
      new_str[j] = ''
      j -= 1
      i = skip_chars_for(str, i, len)
      next
    end

    if i + 1 < len && str[i] == str[i+1]
      i = skip_chars_for(str, i, len)
      next
    end

    j += 1
    new_str[j] = str[i]
    i += 1
  end

  return new_str
end


def skip_chars_for(str, i, len)
  chr = str[i]
  i += 1
  while i < len && str[i] == chr
    i += 1
  end
  return i
end

['geeksforgeek', 'acaaabbbacdddd', 'aabccbda', 'azxxzy', 'geeksforgeeg',
  'caaabbbaacdddd', 'acaaabbbacdddd', 'aabccba'].each do |str|
  puts "Str: #{str}"
  puts "Output: #{remove_adjecent_duplicates(str)}"
end

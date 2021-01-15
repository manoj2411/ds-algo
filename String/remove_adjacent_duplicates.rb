## Not covering all cases, ex: mississipie should be mpie but getting mipie
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

  new_str
end


def skip_chars_for(str, i, len)
  chr = str[i]
  i += 1
  while i < len && str[i] == chr
    i += 1
  end

  i
end

['geeksforgeek', 'acaaabbbacdddd', 'aabccbda', 'azxxzy', 'geeksforgeeg',
  'caaabbbaacdddd', 'acaaabbbacdddd', 'aabccba', 'mississipie'].each do |str|
  puts "Str: #{str} -->> #{remove_adjecent_duplicates(str)}"
  puts
end

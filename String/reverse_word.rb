# reverse in place, without using extra space
#

DELIMETER = ' '

def reverse_words(line)
  length = line.length
  i = 0
  # reverse words
  while i < length
    j = i
    while line[j] != DELIMETER && j < length
      j += 1
    end
    reverse(line, i, j - 1)
    i = j + 1
  end
  reverse(line, 0, length - 1)
end

def reverse(str, left, right)
  return if left >= right

  while left < right
    str[left], str[right] = str[right], str[left]
    left += 1
    right -= 1
  end
end

[
  'I love tea',
  'getting good at coding needs a lot of practice',
  "    ",
  "  a  ",
  "  hello world!  ",
].each do |line|

  puts "String: \"#{line}\""
  reverse_words(line)
  puts "=> \"#{line}\""
  puts
end

str = "the house is blue, it looks beautiful."

puts 'Initial string: ' + str


words_arr = []

i = 0
tmp_word = ''
while(i <= str.length)
  if str[i] == ' '
    words_arr.push tmp_word
    tmp_word = ''
  elsif str[i].nil?
    tmp_word = tmp_word[0..-2] if tmp_word[-1] == '.'
    words_arr.push tmp_word
  else
    tmp_word << str[i]
  end
  i += 1
end

str = ''
i = words_arr.length - 1
while i >= 0
  str << words_arr[i]
  str << " " if i != 0
  i -= 1
end
str << '.' if str[-1] != '.'

puts 'Result string: ' + str






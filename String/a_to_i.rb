def a_to_i(str)
  return -1 if str.nil? || str.empty?

  result = 0
  base = '0'.ord

  sign = 1
  i = 0
  if str[0] == '-'
    i = 1
    sign = -1
  end

  for j in i...str.length
    chr = str[j]

    if chr.ord - base > 9 || chr.ord - base < 0
      return -1
    end
    result = (result * 10) + chr.ord - base
  end
  return sign * result
end

['123', '21a', '-134'].each do |str|
  puts "Str: #{str} \t #{a_to_i(str)}"
end

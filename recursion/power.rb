def power(num, pow)

  if pow == 0
    return 1
  elsif pow % 2 == 1
    res = power(num, pow / 2)
    return num * res * res
  else
    res = power(num, pow / 2)
    return res * res
  end
end


for input in [[2,5], [2,6], [2,7],[3,5], [3,6], [3,7]]
  puts "Input: #{input.join('^')} - "
  puts "#{power *input}"
end

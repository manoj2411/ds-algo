def next_greater_elements(arr)
  stack = [arr[0]]

  for i in 1...arr.length
    while !stack.empty? && stack.last < arr[i]
      puts "#{stack.pop} -> #{arr[i]}"
    end
    stack.push arr[i]
  end

  while !stack.empty?
    puts "#{stack.pop} -> -1"
  end
end


[[4,5,2,7,25,9,12,17], [4,5,2,7,25,9,12,170], [4, 5, 2, 25],
 [13, 7, 6, 12], [11, 13, 21, 3]].each do |arr|
  puts "Arr: #{arr}"
  next_greater_elements(arr)
  puts "\n"
end

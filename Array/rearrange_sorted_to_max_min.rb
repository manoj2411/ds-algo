def rearrange(arr)
  max = arr[arr.length - 1] + 1
  head = 0
  tail = arr.length - 1
  0.upto(arr.length - 1) do |i|
    if i.even?
      arr[i] += ((arr[tail] % max) * max) #+ (arr[i] % max)
      tail -= 1
    else
      arr[i] += ((arr[head] % max) * max) #+ (arr[i] % max)
      head += 1
    end
  end

  print "New: "
  arr.each do |ele|
    print "#{ele / max} "
  end
end


arr = (1..9).to_a

puts "Original: #{arr}"
rearrange(arr)
puts "Original: #{arr}"

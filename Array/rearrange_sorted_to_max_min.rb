def rearrange(arr)
  max = arr.last + 1
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

  for i in 0...(arr.length)
    arr[i] = arr[i] / max
  end
end


arr = (1..9).to_a

puts "Input: #{arr}"
rearrange(arr)
puts "Result: #{arr}"


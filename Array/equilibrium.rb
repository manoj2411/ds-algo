def find_equilibrium(arr)
  len = arr.length
  sum = arr.reduce(:+)
  lsum = arr[0]

  i = 1

  while i < len
    if lsum == (sum - arr[i] - lsum)
      # puts "equilibrium index found at #{i}"
      return i
    else
      lsum += arr[i]
    end
    i += 1
  end

  # print 'Array has no equilibrium point'
  -1
end


def find_equilibrium_elegant(arr)

  sum = 0
  arr.each { |e| sum += e }

  left_sum = arr[0]
  sum -= arr[0]
  for i in 1..(arr.length - 2)
    sum -= arr[i]
    return i if sum  == left_sum
    left_sum += arr[i]
  end
  -1
end


for input in [
  [-7,1,5,2,-4,3,0], # 3
  [1,2,3], # -1
  [0,-7,1,5,2,-4,3,0], # 4
  [-7,1,5,2,-4,3,-7], # 2
  [-1, 3, -4, 5, 1, -6, 2, 1], #1
  [1,3,4,10,18,3,1,6,3,1,4], # 4
  [1, 2, 3, 3], # 2
]
  puts "Input: #{input}"
  # puts "Result: #{find_equilibrium input}"
  puts "Result: #{find_equilibrium_elegant input}"

end

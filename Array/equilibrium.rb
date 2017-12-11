def find_equilibrium(arr, len)
  sum = arr.reduce(:+)
  lsum = arr[0]
  puts "equilibrium index found at #{0}" if lsum == (sum - lsum)

  i = 1

  while i < len
    if lsum == (sum - arr[i] - lsum)
      puts "equilibrium index found at #{i}"
      return
    else
      lsum += arr[i]
    end
    i += 1
  end

  print 'Array has no equilibrium point'
end


# arr = [-7, 1, 5, 2, -4, 3, 0]
# arr = [1, 2, 3, 3]
# arr = [1,3,4,10,18,3,1,6,3,1,4]
arr =  [-1, 3, -4, 5, 1, -6, 2, 1 ]

find_equilibrium(arr, arr.length)

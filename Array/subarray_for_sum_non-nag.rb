def subarray_with_sum(arr, given_sum)
  start = 0
  i = 1
  sum = arr[start]

  # since the value of sum is adjusted after comparing the given_sum, we need 1 more
  #  iteration to reach to the sum & given_sum comparision.
  while i <= arr.length
    #  start < (i - 1) making sure that we are not removing all the items from sum
    #   with this there will be always a gap of at least 1 in start & i
    while sum > given_sum && start < (i - 1)
      sum -= arr[start]
      start += 1
    end

    if given_sum == sum
      puts "The lies between #{start} and #{i - 1 }"
      return true
    end

    if i < arr.length
      sum += arr[i]
    end
    i += 1
  end
  # puts "start: #{start} i: #{i}"
  puts "No subarray found! "
end



for arr, sum in [
  [[1,2,3,7,5], 12], # [1,3]
  [[1,2,3,7,5], 15], # [2,4]
  [[1,2,3,7,5], 27], # -1
  [[1,2,3,7,5], 2],  # [1,1]
  [[1,2,3,4,5,6,7,8,9,10], 15], # [0,4]
  [[1,4,20,3,10,5], 33], # [2,4]
  [[1,4,0,0,3,10,5],7], # [1,4]
  [[2,4], 1], # -1
  [[1,4], 0], # -1

]
  puts "Arr: #{arr}, sum: #{sum}"
  subarray_with_sum(arr, sum)
  puts
end


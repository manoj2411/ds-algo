def subarray_with_sum(arr, count)
  start = 0
  i = 1
  sum = arr[start]

  while i <= arr.length

    while sum > count && start < (i - 1)
      sum -= arr[start]
      start += 1
    end

    if count == sum
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

# arr = [10,2,1,4,20]
# sum = 6
arr = [1, 4, 20, 3, 10, 5]
sum = 23
# arr = [1, 4, 0, 0, 3, 10, 5]
# sum = 20
puts "Arr: #{arr}, sum: #{sum}"
subarray_with_sum(arr, sum)

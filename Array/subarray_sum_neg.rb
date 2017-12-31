def subarray_with_sum(arr, sum)
  c_sum = 0
  hs = {}
  0.upto(arr.length - 1) do |i|
    c_sum += arr[i]

    if c_sum == sum
      puts "Sum exists between #{0} and #{i}"
      return [0,i]
    end

    if hs[c_sum - sum]
      puts "Sum exists between #{hs[c_sum - sum] + 1} and #{i}"
      return [hs[c_sum - sum] + 1, i]
    end
    hs[c_sum] = i
  end
  puts 'No result found!'
end

arr = [11,15,-2,-20,10]
sum = 13
sum = 10
sum = -10
sum = -7
sum = -12

arr = [1, 4, 20, 3, 10, 5]
sum = 33

arr = [10, 2, -2, -20, 10]
sum = -10

arr = [-10, 0, 2, -2, -20, 10]
sum = 20
puts "Array: #{arr}\nSum:#{sum}"

res = subarray_with_sum(arr,sum)
puts res.to_s

# recursive approach

def how_many_way_to_change(arr, sum)
  if !arr.is_a?(Array) || arr.empty? || !sum.is_a?(Numeric) || sum <= 0
    return -1
  end
  return helper(arr, sum, arr.length - 1)
end

def helper(arr, sum, right)
  if sum == 0
    return 1
  elsif sum < 0 || right < 0
    return 0
  end

  return helper(arr, sum - arr[right], right) + helper(arr, sum, right - 1)
end


[[[1,2,3], 4], [[2, 5, 3, 6], 10]].each do |input|
  puts "Input: #{input[0]} - #{input[1]}"
  puts "Result: #{how_many_way_to_change *input}"
end

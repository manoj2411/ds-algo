# Given an integer array nums, find the contiguous subarray (containing at least one number)
#  which has the largest sum and return its sum.
def max_subarray(nums)
  result = curr_sum = nums.first

  for i in 1...(nums.length)
    if nums[i] > nums[i] + curr_sum # nums[i] + curr_sum < 0 ||
      curr_sum = nums[i]
    else
      curr_sum += nums[i]
    end
    result = curr_sum if curr_sum > result
  end
  result
end


for input in [
  [-2,-1,-3], # -1
  [-2,-1,0,-3], # 0
  [-2,-1,-3, 5, -3], # 5
  [-2,1,-3,4,-1,2,1,-5,4], # 6
  [4,-1,2,1], # 6
 ]

  puts "Arr: #{input}"
  puts max_subarray(input)
end

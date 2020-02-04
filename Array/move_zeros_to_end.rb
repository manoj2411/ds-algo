# Move all zeroes to end of array with minimum operations and in-place
def move_zeros_to_end(nums)
  length = nums.length
  i = j = 0

  while i < length && j < length

    while i < length && nums[i] != 0
      i += 1
    end

    break if i >= length

    j = i + 1 if j <= i

    while j < length && nums[j] == 0
      j += 1
    end
    break if j >= length

    nums[i], nums[j] = nums[j], nums[i]
    i += 1
    j += 1
  end
end


for input in [
  [0,1,0,3,12],
  [4,2,4,0,0,3,0,5,1,0]
]

  puts "Input: #{input}"
  move_zeros_to_end(input)
  puts "Result: #{input}"
end

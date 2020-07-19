# Given an array of integers and a target value. Find the number of ways that you
# can add and subtract the values in nums to add up to T.
#
def target_sum(nums, target)
  helper(nums, target, 0, 0)
end

def helper(a, target, sum, i)
  if i == a.length
    sum == target ? 1 : 0
  else
    helper(a, target, sum + a[i], i + 1) +
    helper(a, target, sum - a[i], i + 1)
  end
end

for arr, target in [
  [[1,1,1,1,1], 3], # 5
]
  puts target_sum(arr, target)
end

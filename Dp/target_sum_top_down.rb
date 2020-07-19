# https://leetcode.com/problems/target-sum/
#
# Given an array of integers and a target value. Find the number of ways that you
# can add and subtract the values in nums to add up to T.
#
def target_sum(nums, target)
    cache = Array.new(nums.length) { Array.new(2001) }
    helper(nums, target, 0, 0, cache)
end

def helper(a, target, sum, i, cache)
  if i == a.length
    sum == target ? 1 : 0
  elsif cache[i][1000 + sum]
    cache[i][1000 + sum]
  else
    cache[i][1000 + sum] =
      helper(a, target, sum + a[i], i + 1, cache) +
      helper(a, target, sum - a[i], i + 1, cache)
  end
end

for arr, target in [
  [[1,1,1,1,1], 3], # 5
]
  puts target_sum(arr, target)
end

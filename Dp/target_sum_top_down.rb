def target_sum(nums, target)
  helper(nums, target, 0, 0, {})
end

def helper(a, target, sum, i, cache)
  if i == a.length
    sum == target ? 1 : 0
  elsif cache[[sum, i]]
    cache[[sum, i]]
  else
    cache[[sum, i]] =
      helper(a, target, sum + a[i], i + 1, cache) +
      helper(a, target, sum - a[i], i + 1, cache)
  end
end

for arr, target in [
  [[1,1,1,1,1], 3], # 5
]
  puts target_sum(arr, target)
end

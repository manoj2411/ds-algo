def combinational_sum(arr, sum)
  result = []
  helper(arr.sort, [], result, sum, 0)
  return result.uniq
end

def helper(arr, curr, result, sum, i)
  if sum == 0
    if !result.index(curr)
      result << curr
    end
    return
  end

  for j in i...arr.length
    return if arr[j] > sum

    # curr.push(arr[j])
    helper(arr, curr + [arr[j]], result, sum - arr[j], j + 1)
    # curr.pop
  end
end

arr = [10,1,2,7,6,1,5]
sum = 8
res = combinational_sum(arr, sum)

for lst in res
  puts lst.to_s
end

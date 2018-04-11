def combinational_sum(arr, sum)
  result = []
  curr = []
  helper(arr.sort, curr, result, sum, 0)
  return result.uniq
end

def helper(arr, curr, result, sum, i)
  if sum == 0
    result << curr.clone
    return
  end

  for j in i...arr.length
    if sum - arr[j] < 0
      return
    end
    curr.push(arr[j])
    helper(arr, curr, result, sum - arr[j], j + 1)
    curr.pop
  end
end

arr = [10,1,2,7,6,1,5]
sum = 8
res = combinational_sum(arr, sum)

for lst in res
  puts lst.to_s
end

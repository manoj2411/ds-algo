def bsearch(arr, key)
  low = 0
  high = arr.length - 1

  while high >= low
    mid = (high + low) / 2

    if key < arr[mid]
      high = mid - 1
    elsif key > arr[mid]
      low = mid + 1
    else
      return mid
    end
  end
  -1
end

def bsearch_recur(arr, k, low, high)
  return -1 if low > high

  mid = (low + high) / 2

  if k > arr[mid]
    bsearch_recur(arr, k, mid + 1, high)
  elsif k < arr[mid]
    bsearch_recur(arr, k, low, mid - 1)
  else
    return mid
  end
end

for arr, k in [
    [[], 2], # -1
    [[0,2], 2], # 1
    [[0,2], 0], # 0
    [[0,2], 1], # -1
    [[1,2,3,4], 2], # 1
    [[1,2,3,4], 1], # 0
    [[1,2,3,4], 0], # -1
    [[1,2,3,4], 4], # 3
    [[1,2,3,4,5], 4], # 3
    [[1,2,3,4,5], 5], # 4
    [[1,2,3,4,5], 15], # -1
    [[2,5,8,12,16,23,38,56,72], 72]
]
    puts "Binary Search : #{arr}, #{k}"
    puts "#{bsearch(arr, k)}"
    puts "#{bsearch_recur(arr, k, 0, arr.length - 1)}"
end

def bsearch(arr, key)
  low = 0
  high = arr.length - 1
  while high > low
    mid = (high + low) / 2
    if arr[mid] == key
      return mid
    elsif key > arr[mid]
      low = mid + 1
    else
      high = mid - 1
    end
  end
  return nil
end

def bsearch_recur(arr, k, low, high)
  if low <= high
    mid = (low + high) / 2
    if arr[mid] == k
      return true
    elsif k < arr[mid]
      binary_search(arr, k, low, mid - 1)
    else
      binary_search(arr, k, mid + 1, high)
    end
  else
    return false
  end
end

arr = [2,5,8,12,16,23,38,56,72]
key = 72
puts "Array: #{arr}"
puts "has key #{key} at: #{bsearch(arr, key) || 'Not found'}"

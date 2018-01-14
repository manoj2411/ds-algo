def quick(arr, low, high, k)
  if low <= high
    pivot_indx = partition(arr, low, high)
    puts "low: #{low} piv: #{pivot_indx} high: #{high} k:#{k} #{arr}"
    if pivot_indx == (k - 1)
      puts "found at #{pivot_indx}"
      return arr[pivot_indx]
    elsif pivot_indx > (k - 1)
      quick(arr, low, pivot_indx - 1, k)
    else
      quick(arr, pivot_indx + 1, high, k)
    end
  end
end

def partition(arr, low, high)
  pivot = arr[high]
  i = mid = low
  while (i < high)
    if arr[i] > pivot
      i += 1
    else
      tmp = arr[mid]
      arr[mid] = arr[i]
      arr[i] = tmp
      mid += 1
      i += 1
    end
  end
  tmp = arr[mid]
  arr[mid] = arr[high]
  arr[high] = tmp
  return mid
end

arr = [7, 10, 4, 3, 20, 15]
# arr = [6, 1,2,11,7,4]

puts quick(arr, 0, arr.length - 1, 5)

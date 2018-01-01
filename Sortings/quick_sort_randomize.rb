def quick_sort(arr, min, max)
  if min < max
    mid = partition(arr, min, max)
    quick_sort(arr, min, mid - 1)
    quick_sort(arr, mid + 1, max)
  end
end

def partition(arr, min, max)

  random_indx = rand(min..max)
  arr[random_indx], arr[max] = arr[max], arr[random_indx]

  pivot_indx = min - 1
  pivot = arr[max]

  min.upto(max) do |i|
    if arr[i] <= pivot
      pivot_indx += 1
      tmp = arr[i]
      arr[i] = arr[pivot_indx]
      arr[pivot_indx] = tmp
    end
  end
  return pivot_indx

end

arr = [10, 6, 12, 1, 4, 2, 3]
# arr = [10, 80, 30, 90, 50, 40, 70]
# arr = [10, 7, 8, 9, 1, 5]

puts "Original Array: #{arr}"
quick_sort(arr, 0, arr.length - 1)
puts "Sorted Array: #{arr}"

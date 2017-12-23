# time complexity: O(n^2)
#
# QuickSort is faster in practice, because its inner loop can be efficiently
# implemented on most architectures, and in most real-world data.
# However, merge sort is generally considered better when data is huge and
# stored in external storage
#
# (sorting Arrays)
# its general form is an in-place sort whereas merge sort requires O(N) extra storage
#
# Most practical implementations of Quick Sort use "randomized version", has expected
# time complexity of O(nLogn). The worst case is possible in randomized version also,
# but worst case doesn’t occur for a particular pattern (like sorted array) and
# randomized Quick Sort works well in practice.
#
# Its also tail recursive, therefore tail call optimizations is done
#
# let the address of A[0] be x then to access A[i], we can directly access the
# memory at (x + i*4). Unlike arrays, we can not do random access in linked list
# In linked list to access i’th index, we have to travel each and every node from
# the head to i’th node as we don’t have continuous block of memory


module QuickSort
  extend self

  def sort(arr, low, high)
    if low < high
      pivot_indx = set_pivot(arr, low, high)

      sort(arr, low, pivot_indx - 1)
      sort(arr, pivot_indx + 1, high)
      return arr
    end
  end
end


def set_pivot(arr, low, high)
  left_indx = low
  i = low
  pivot = arr[high]
  while i <= (high - 1)
    if arr[i] < pivot
      arr[left_indx], arr[i] = arr[i], arr[left_indx]
      left_indx += 1
    end
    i += 1
  end
  arr[left_indx], arr[high] = pivot, arr[left_indx]
  return left_indx
end


# arr = [10, 80, 30, 90, 50, 40, 70]
arr = [10, 7, 8, 9, 1, 5]
puts "Original List: #{arr}\n"

QuickSort.sort(arr, 0, arr.length - 1)

puts puts "Sorted List: #{arr}"

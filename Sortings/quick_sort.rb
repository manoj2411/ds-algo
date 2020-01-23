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

  def sort(arr)
    helper(arr, 0, arr.length - 1)
  end

  private
    def helper(arr, left, right)
      if left < right
        pivot_indx = partition(arr, left, right)

        helper(arr, left, pivot_indx - 1)
        helper(arr, pivot_indx + 1, right)
      end
    end

    def partition(arr, left, right)
      pivot = arr[right]
      pivot_index = left - 1

      for i in left..right
        if arr[i] <= pivot
          pivot_index += 1
          arr[pivot_index], arr[i] = arr[i], arr[pivot_index]
        end
      end
      pivot_index
    end
end



for arr in [[10, 7, 8, 9, 1, 5], [10, 80, 30, 90, 50, 40, 70]]
  puts "Original List: #{arr}"
  QuickSort.sort(arr)
  puts "Sorted List: #{arr}"
  puts
end


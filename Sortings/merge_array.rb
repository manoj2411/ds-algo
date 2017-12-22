# Time complexity of Merge Sort is Ø(nLogn) in all 3 cases (worst, average and best)
# as merge sort always divides the array in two halves and take linear time
# to merge two halves.
#
# Auxiliary Space: O(n)
#
# Algorithmic Paradigm: Divide and Conquer
#
# Sorting In Place: No in a typical implementation
#
#
# Applications:
#
# 1. O(nLog(n) sorting list is linkedlist
# 2. External sorting
# 3. Count Inversions in an array

module MergeSort
  # extend self
  module_function

  def sort_arr(arr, left, right)
    if right > left
      mid = (left + right) / 2

      sort_arr(arr, left, mid)
      sort_arr(arr, mid + 1, right)
      merge(arr, left, mid, right)
    end
  end

  def merge(arr, left, mid, right)
    list1 = arr[left..mid]
    list2 = arr[(mid + 1)..right]

    i = 0 # representing curr indx value for list1
    j = 0 # representing curr indx value for list2
    k = left # representing curr index value for arr

    while( i < list1.length and j < list2.length)
      if list1[i] < list2[j]
        arr[k] = list1[i]
        i += 1
      else
        arr[k] = list2[j]
        j += 1
      end
      k += 1
    end

    while i < list1.length
      arr[k] = list1[i]
      i += 1
      k += 1
    end

    while j < list2.length
      arr[k] = list2[j]
      j += 1
      k += 1
    end
  end

end

arr = [12, 11, 13, 5, 6, 7]
puts "Old list: #{arr}"
MergeSort.sort_arr(arr, 0, arr.length - 1)
puts "New list: #{arr}"

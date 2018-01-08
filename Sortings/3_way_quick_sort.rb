module ThreeWayQuickSort
  extend self

  def quick_3_way(arr, low, high)
    if high > low
      pivot_s, pivot_e = partition(arr, low, high)
      quick_3_way(arr, low, pivot_s - 1)
      quick_3_way(arr, pivot_e + 1, high)
    end
  end

  private
    def partition(arr, low, high)
      pivot = arr[high]

      # apply russian flag problem' solution to the list
      left = low
      mid = low
      right = high

      while mid <= right
        if arr[mid] == pivot
          mid += 1
        elsif arr[mid] > pivot
          tmp = arr[right]
          arr[right] = arr[mid]
          arr[mid] = tmp
          right -= 1
        else
          tmp = arr[left]
          arr[left] = arr[mid]
          arr[mid] = tmp
          left += 1
          mid += 1
        end
      end
      return left, mid - 1
    end

end

# arr = [1, 4, 2, 5,4, 2,3, 4, 1, 2,4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4]
# arr = [10, 6, 12, 1, 4, 2, 3]
arr = [4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4]
puts "Original Array: #{arr}"
ThreeWayQuickSort.quick_3_way(arr, 0, arr.length - 1)
puts "Sorted Array: #{arr}"



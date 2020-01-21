module ThreeWayQuickSort
  extend self

  def sort(arr)
    quick_3_way(arr, 0, arr.length - 1)
  end

  private
    def quick_3_way(arr, low, high)
      if high > low
        pivot_s, pivot_e = partition(arr, low, high)
        quick_3_way(arr, low, pivot_s - 1)
        quick_3_way(arr, pivot_e + 1, high)
      end
    end

    def partition(arr, low, high)
      pivot = arr[high]

      # apply russian flag problem' solution to the list
      left = low - 1
      mid = low
      right = high

      while mid <= right
        if arr[mid] == pivot
          mid += 1
        elsif arr[mid] > pivot
          arr[right], arr[mid] = arr[mid], arr[right]
          right -= 1
        else
          left += 1
          arr[left], arr[mid] = arr[mid], arr[left]
          mid += 1
        end
      end
      return left + 1, mid - 1
    end

end


for arr in [[4,9,4,4,1,9,4,4,9,4,4,1,4], [1,4,2,5,4,2,3,4,1,2,4,1,2,2,2,2,4,1,4,4,4], [10,6,12,1,4,2,3]]
  puts "Original Array: #{arr}"
  ThreeWayQuickSort.sort(arr)
  puts "Sorted Array: #{arr}"
  puts
end



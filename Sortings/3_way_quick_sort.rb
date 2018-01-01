module ThreeWayQuickSort
  extend self

  def qsort(arr, low, high)
    if low < high
      piv_start_i, piv_end_i = partition(arr, low, high)
      puts "low: #{low}, high: #{high}, #{[piv_start_i, piv_end_i].to_s} : #{arr}"
      qsort(arr, low, piv_start_i - 1)
      qsort(arr, piv_end_i + 1, high)
    end
  end

  private
    def partition(arr, low, high)
      pivot       = arr[high]
      piv_start_i = low
      piv_end_i   = low

      low.upto(high) do |i|
        if arr[i] == pivot
          arr[i]         = arr[piv_end_i ]
          arr[piv_end_i] = pivot
          piv_end_i      += 1
        elsif arr[i] < pivot
          tmp = arr[piv_start_i]
          arr[piv_start_i] = arr[i]
          arr[i] = arr[piv_end_i]
          arr[piv_end_i] = tmp
          piv_end_i += 1
          piv_start_i += 1
        end
        # No change in piv_end_i and piv_start_i, just "i" will be
        # incremented in case arr[i] > pivot
      end
      return [piv_start_i, piv_end_i - 1]
    end
end

arr = [1, 4, 2, 5,4, 2,3, 4, 1, 2,4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4]
# arr = [10, 6, 12, 1, 4, 2, 3]
arr = [4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4]
puts "Original Array: #{arr}"
ThreeWayQuickSort.qsort(arr, 0, arr.length - 1)
puts "Sorted Array: #{arr}"

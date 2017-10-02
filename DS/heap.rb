require 'byebug'

class Heap

  def initialize(list = [])
    @arr = [nil] + list
  end

  def length
    # -1 to manage prepended nil value in the list
    @arr.length - 1
  end

  def max_heapify
    i = (length / 2) + 1
    while(i >= 1)
      rearrange_for_max_heap(i)
      i -= 1
    end
  end

  def min_heapify
    i = (length / 2) + 1
    while(i >= 1)
      rearrange_for_min_heap(i)
      i -= 1
    end
  end

  def arr
    @arr
  end

  private
    def rearrange_for_max_heap(i)
      left = i * 2
      right = (i * 2) + 1

      larger = i
      larger = left if (left <= length && arr[left] > arr[larger])
      larger = right if (right <= length && arr[right] > arr[larger])

      if larger != i
        swap(i, larger)
        rearrange_for_max_heap(larger)
      end
    end

    def rearrange_for_min_heap(i)
      left = i * 2
      right = (i * 2) + 1

      smaller = i
      smaller = left if (left <= length && arr[left] < arr[smaller])
      smaller = right if (right <= length && arr[right] < arr[smaller])

      if smaller != i
        swap(i, smaller)
        rearrange_for_min_heap(smaller)
      end
    end

    def swap(i, j)
      tmp    = arr[i]
      arr[i] = arr[j]
      arr[j] = tmp
    end
end

heap = Heap.new [2,0,1,3,6,5,4]
heap.min_heapify
debugger
true

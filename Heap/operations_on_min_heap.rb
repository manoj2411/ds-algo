class MinHeap
  attr_reader :size, :arr

  def initialize
    @arr = []
  end

  # insert an item in the min heap with value x
  def insert_key(item)
    arr << item
    indx = arr.length - 1
    while indx != 0
      parent = (indx - 1) / 2
      if arr[parent] < arr[indx]
        break
      else
        heapify(parent)
        indx = parent
      end
    end
  end

  # remove an element at position x from the min heap
  def delete_key(position)
  end

  # removes the min element from the min heap and prints it
  def extract_min
  end

  private
    def heapify(indx)
      len = arr.length
      left_child = (indx * 2) + 1
      right_child = (indx * 2) + 2

      smaller = indx
      if left_child < len and arr[smaller] > arr[left_child]
        smaller = left_child
      end

      if right_child < len and arr[smaller] > arr[right_child]
        smaller = right_child
      end

      if smaller != indx
        arr[smaller], arr[indx] = arr[indx], arr[smaller]
        heapify(smaller)
      end
    end
end

heap = MinHeap.new
heap.insert_key 4
heap.insert_key 2
heap.extract_min # => 2
heap.insert_key 6
heap.delete_key 0 # (4) deleted
heap.extract_min #=> 6
heap.extract_min #=> -1

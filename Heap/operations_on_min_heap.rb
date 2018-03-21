class MinHeap
  attr_reader :size, :arr

  def initialize
    @arr = []
  end

  # insert an item in the min heap with value x
  def insert(item)
    arr << item
    indx = right
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
  def delete(position)
    if position > right
      puts "NA"
      return
    end

    arr[position], arr[right] = arr[right], arr[position]
    item = arr.pop
    heapify(position)
    return item
  end

  def right
    arr.length - 1
  end

  # removes the min element from the min heap and prints it
  def extract_min
    if right >= 0
      arr[0], arr[right] = arr[right], arr[0]
      item = arr.pop
      heapify(0)
      # puts item
      return item
    else
      return -1
    end
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
heap.insert 4
heap.insert 2
puts heap.extract_min # => 2
heap.insert 6
heap.delete 0 # (4) deleted
puts heap.extract_min #=> 6
puts heap.extract_min #=> -1


heap.insert 4
heap.insert 2
heap.insert 6
heap.insert 3
heap.insert 1
heap.insert 8
heap.insert 5
puts heap.arr.join(', ')
heap.delete 1
puts heap.arr.join(', ')


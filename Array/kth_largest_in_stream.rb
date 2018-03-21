class MinHeap

  attr_reader :arr

  def initialize
    @arr = []
  end

  def length
    @arr.length
  end
  alias_method :size, :length

  def min
    @arr.first
  end

  def replace_at(indx, item)
    if indx >= size
      puts 'Invalid replacement'
      return
    end

    @arr[indx] = item
    heapify(indx)
  end

  def insert(key)
    arr << key
    i = limit
    while i != 0
      parent_i = parent(i)
      if arr[parent_i] > arr[i]
        arr[parent_i], arr[i] = arr[i], arr[parent_i]
        i = parent_i
      else
        break
      end
    end
  end

  private
    def parent(i)
      (i - 1) * 2
    end

    def left_c(i)
      (i * 2) + 1
    end

    def right_c(i)
      (i * 2) + 2
    end

    def limit
      size - 1
    end

    def heapify(i)
      left_child = left_c(i)
      right_child = right_c(i)

      smaller = i

      if left_child < size and arr[left_child] < arr[smaller]
        smaller = left_child
      end

      if right_child < size and arr[right_child] < arr[smaller]
        smaller = right_child
      end

      if smaller != i
        arr[i], arr[smaller] = arr[smaller], arr[i]
        heapify(smaller)
      end
    end
end



def process_stream(stream, k)
  heap = MinHeap.new
  stream.each do |item|
    if heap.size < k
      heap.insert(item)
      if heap.size == k
        print "#{heap.min} "
      else
        print "_ "
      end
      next
    end

    if item > heap.min
      heap.replace_at(0, item)
    end
    print "#{heap.min} "
  end
  puts
end


arr = [10, 20, 11, 70, 50, 40, 100, 5]
k = 3
puts "Stream: #{arr} - k: #{k}"
process_stream(arr, k)

# Abstract class
class HeapBase
  attr_reader :size

  def initialize
    @arr = []
  end

  def top
    @arr[0]
  end

  def size
    @arr.length
  end

  def extract
    raise 'cannot extract from empty!' if size.zero?

    @arr[0], @arr[size - 1] = @arr[size - 1], @arr[0]
    extracted_key = @arr.pop
    heapify(0)
    return extracted_key
  end

  def insert(x)
    raise 'to be implemented by subclass'
  end

  def heapify(i)
    raise 'to be implemented by subclass'
  end

  def parent(i)
    (i - 1) / 2
  end

  def left_child(i)
    (i * 2) + 1
  end

  def right_child(i)
    (i * 2) + 2
  end

  def pp
    puts @arr.to_s
  end
end

class MinHeap < HeapBase

  def insert(x)
    i = size
    @arr[i] = x

    while i != 0 && @arr[parent(i)] > @arr[i]
      @arr[parent(i)], @arr[i] = @arr[i], @arr[parent(i)]
      i = parent(i)
    end
    # pp
  end

  def heapify(i)
    min = i
    _left_child = left_child(i)
    _right_child = right_child(i)
    if _left_child < size && @arr[_left_child] < @arr[min]
      min = _left_child
    end

    if _right_child < size && @arr[_right_child] < @arr[min]
      min = _right_child
    end

    if min != i
      @arr[min], @arr[i] = @arr[i], @arr[min]
      heapify(min)
    end
  end
end

class MaxHeap < HeapBase

  def insert(x)
    i = size
    @arr[i] = x

    while i != 0 && @arr[parent(i)] < @arr[i]
      @arr[parent(i)], @arr[i] = @arr[i], @arr[parent(i)]
      i = parent(i)
    end
    # pp
  end

  def heapify(i)
    max = i
    _left_child = left_child i
    _right_child = right_child i
    if _left_child < size && @arr[_left_child] > @arr[max]
      max = _left_child
    end
    if _right_child < size && @arr[_right_child] > @arr[max]
      max = _right_child
    end
    if max != i
      @arr[max], @arr[i] = @arr[i], @arr[max]
      heapify(max)
    end
  end
end

def find_media_in_stram(arr)
  median = 0
  left = MaxHeap.new
  right = MinHeap.new

  arr.each do |key|
    median = get_median(key, median, left, right)
    print "#{median} "
  end
  puts
end

def get_median(key, median, left, right)

  case left.size - right.size
  when 0
    if key < median
      left.insert(key)
      return left.top
    else
      right.insert(key)
      return right.top
    end
  when 1
    if key > median
      right.insert(key)
    else
      right.insert(left.extract)
      left.insert(key)
    end
    return (left.top + right.top) / 2
  when -1
    if key < median
      left.insert(key)
    else
      left.insert(right.extract)
      right.insert(key)
    end
    return (left.top + right.top) / 2
  else
    raise 'Sherlock, please check I reached here'
  end
end

[[5, 15, 1, 3], [1,2,3,4,5,6,7]].each do |arr|
  puts "Arr: #{arr}"
  find_media_in_stram(arr)
  puts
end

Pair = Struct.new(:char, :count)

class MaxHeap
  attr_reader :arr

  def initialize
    @arr = []
  end

  def size
    @arr.length
  end

  def empty?
    arr.empty?
  end

  def parent(i)
    (i - 1) / 2
  end

  def left_c(i)
    (i * 2) + 1
  end

  def right_c(i)
    (i * 2) + 2
  end

  def insert(pair)
    i = size
    arr[i] = pair
    pi = parent(i)
    while i != 0 && arr[pi].count < arr[i].count
      arr[i], arr[pi] = arr[pi], arr[i]
      i = pi
      pi = parent(i)
    end
  end

  def extract
    if size == 0
      raise 'NA'
    elsif size == 1
      arr.pop
    else
      last = size - 1
      arr[0], arr[last] = arr[last], arr[0]
      item = arr.pop
      heapify(0)
      return item
    end
  end

  def heapify(i)
    max = i
    lc = left_c(i)
    rc = right_c(i)

    if lc < size && arr[lc].count > arr[max].count
      max = lc
    end
    if rc < size && arr[rc].count > arr[max].count
      max = rc
    end
    if i != max
      arr[max], arr[i] = arr[i], arr[max]
      heapify(max)
    end
  end
end

def rearrange(str)
  hs = Hash.new(0)
  heap = MaxHeap.new
  result = ''
  prev = Pair.new('', 0)
  curr = nil

  str.each_char {|chr| hs[chr] += 1 }
  hs.each_pair {|char, count| heap.insert(Pair.new(char, count))}

  while not heap.empty?
    curr = heap.extract
    result << curr.char
    curr.count -= 1
    if prev.count > 0
      heap.insert(prev)
    end
    prev = curr
  end

  if result.length == str.length
    return result
  else
    return 'Not Possible'
  end
end


for str in ['aaabc', 'aaabb', 'aa', 'aaaabc']
  puts "Input: #{str}\nOutput: #{rearrange str}"
  puts
end

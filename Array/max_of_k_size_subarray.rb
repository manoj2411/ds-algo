Node = Struct.new(:key, :next, :prev)

class Dque

  def initialize
    @start = @end = nil
  end

  def insert_e(key)
    node = Node.new key
    if @start.nil?
      @start = @end = node
    else
      @end.next = node
      node.prev = @end
      @end = node
    end
  end

  def remove_e
    if @start.nil?
      put 'Dque is already empty'
    elsif @start == @end
      @start = @end = nil
    else
      @end = @end.prev
      @end.next = nil
    end
  end

  def remove_s
    if @start.nil?
      put 'Dque is already empty'
    elsif @start == @end
      @start = @end = nil
    else
      @start = @start.next
      @start.prev = nil
    end
  end

  def empty?
    @start.nil?
  end

  def first
    @start.key unless @start.nil?
  end

  def last
    @end.key unless @end.nil?
  end

end

def sliding_window_max(arr, k)
  return if k > arr.length

  j = 0
  dque = Dque.new
  while j < k
    while !dque.empty? && arr[dque.last] < arr[j]
      dque.remove_e
    end
    dque.insert_e(j)
    j += 1
  end

  i = 0

  print "#{arr[dque.first]} "
  while j < arr.length
    while !dque.empty? && arr[dque.last] < arr[j]
      dque.remove_e
    end
    dque.insert_e(j)
    j += 1
    i += 1
    # dque.print_s
    print "#{arr[dque.first]} "
  end
  puts
end

[[[1,2,3,1,4,5,2,3,6], 3], [[8,5,10,7,9,4,15,12,90,13], 4]].each do |input|
  arr, k = input
  puts "Input: #{arr} - k:#{k}"
  puts 'Output: '
  sliding_window_max(arr, k)
end


# alternate implementation

def sliding_window_max2(arr, k, n)
  return if k > n || k <= 0
  deque = []

  for i in 0...k
    while !deque.empty? && deque.last[:val] < arr[i]
      deque.pop
    end
    deque << {val: arr[i], i: i}
  end

  print "#{deque.first[:val]} "

  for i in k...n
    deque.pop if deque.first[:i] <= i - k
    while !deque.empty? && deque.last[:val] < arr[i]
      deque.pop
    end
    deque << {val: arr[i], i: i}
    print "#{deque.first[:val]} "
  end

  puts
end

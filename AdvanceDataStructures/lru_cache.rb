Node = Struct.new(:key, :next, :prev)

class Dll
  attr_reader :front, :rear, :size

  def initialize
    @front = @rear = nil
    @size = 0
  end

  def move_to_front(node)
    return if front.nil? || front == node

    if node == rear
      @rear = @rear.prev
      @rear.next = nil
    else
      node.prev.next = node.next
      node.next.prev = node.prev
    end
    node.next = @front
    @front.prev = node
    node.prev = nil
    @front = node
  end

  def pp
    curr = front
    while curr != nil
      print curr.key
      print ' -> '
      curr = curr.next
    end
    puts
  end

  def remove_node_from_rear
    node = rear
    if node.nil?
      raise 'List is empty'
    elsif node == front
      @front = @rear = nil
    else
      @rear = @rear.prev
      @rear.next = nil
    end

    @size -= 1
    return node.key
  end

  def add_to_front(key)
    node = Node.new(key)
    if front.nil?
      @front = @rear = node
    else
      node.next = @front
      @front.prev = node
      @front = node
    end

    @size += 1
    return node
  end
end

class LruCache
  attr_reader :dll, :hsh, :limit

  def initialize(size)
    @limit = size
    @dll = Dll.new
    @hsh = {}
  end

  def size
    dll.size
  end

  def set(key, value)
    if hsh.key?(key)
      hsh[key][:value] = value
      dll.move_to_front(hsh[key][:ref])
    else
      if size == limit
        remove_key = dll.remove_node_from_rear
        hsh.delete(remove_key)
      end
      hsh[key] = {value: value}
      hsh[key][:ref] = dll.add_to_front(key)
    end
  end

  def get(key)
    if hsh.key?(key)
      dll.move_to_front(hsh[key][:ref])
      return hsh[key][:value]
    end
    return -1
  end

  def debug
    hsh.each_pair do |k,v|
      print "#{k} -> #{v[:value]} "
    end
    print "F: #{dll.front.key} "
    print "R: #{dll.rear.key}"
    puts
  end
end

puts 'Example1: '
lru = LruCache.new(2)
lru.set(1,2)
puts lru.get(1)

puts "\nExample2: "
lru = LruCache.new(2)
lru.set(1,2)
lru.set(2,3)
lru.set(1,5)
lru.set(4,5)
lru.set(6,7)
puts lru.get(4)
puts lru.get(1)
puts lru.get(6)

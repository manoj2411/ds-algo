require 'pry'

Node = Struct.new(:key, :next)

class CircularList

  attr_reader :count
  attr_accessor :head, :tail

  def initialize
    @count = 0
    @head = nil
    @tail = nil
  end

  def add_node(val)
    node = Node.new(val)
    # binding.pry
    if count == 0
      self.head = self.tail = node
    else
      tail.next = node
      self.tail = tail.next
    end
    tail.next = head
    @count += 1
  end

  def delete(k, curr)
    if k == 1
      raise 'not implemented for k = 1'
    elsif count == 1
      self.head = self.tail = nil
      @count = 0
      return
    end

    curr ||= head
    # -1 for to reach (k - 1)th node, -1 because we are starting including
    # current node, means counter will be 1 for 2st node.
    (k - 2).times { curr = curr.next}

    if curr.next == head
      self.head = head.next
      tail.next = head
      curr = head
    elsif curr.next == tail
      self.tail = curr
      tail.next = head
      curr = head
    else
      curr.next = curr.next.next
      curr = curr.next
    end
    @count -= 1
    return curr
  end
end


def run_josephus(n, k)
  list = CircularList.new
  for i in 1..n
    list.add_node(i)
  end
  curr = nil
  while list.count != 1
    curr = list.delete(k, curr)
  end
  return curr.key
end

(2..15).each do |e|
  puts "N: #{e} \t #{run_josephus e, 2}"
end

Node = Struct.new(:key, :next)

class LinkList

  attr_accessor :head, :tail
  def initialize
    @head = @tail = nil
  end

  def add_to_list(key)
    node = Node.new(key)
    if head == nil
      self.head = node
      self.tail = node
      return
    end

    self.tail.next = node
    self.tail = tail.next
  end

  def print
    curr = head
    if curr
      keys = []
      while curr != nil
        keys << curr.key
        curr = curr.next
      end
      puts keys.join(' -> ')
    else
      puts "List is empty"
    end
  end

  def self.intersection_list(list1, list2)
    curr1 = list1.head
    curr2 = list2.head

    list = LinkList.new
    while (curr1 != nil && curr2 != nil)
      if curr1.key == curr2.key
        list.add_to_list(curr2.key)
        curr1 = curr1.next
        curr2 = curr2.next
      elsif curr1.key < curr2.key
        curr1 = curr1.next
      else
        curr2 = curr2.next
      end
    end
    list
  end

end

list1 = LinkList.new
list1.add_to_list(1)
list1.add_to_list(2)
list1.add_to_list(3)
list1.add_to_list(4)
list1.add_to_list(5)
list1.add_to_list(6)

list2 = LinkList.new
list2.add_to_list(2)
list2.add_to_list(4)
list2.add_to_list(6)
list2.add_to_list(8)

puts "List1: "
list1.print
puts "List2: "
list2.print

puts "Intersection List: "
LinkList.intersection_list(list1, list2).print

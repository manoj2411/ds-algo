require 'pry'

Node = Struct.new(:key, :next, :child)

def flatten(head)
  curr = head
  tail = curr

  while tail.next != nil
    tail = tail.next
  end

  while curr != nil
    tail.next = curr.child
    while tail.next != nil
      tail = tail.next
    end
    curr = curr.next
  end

  return head
end


head = Node.new(10)
head.next = Node.new(5)
head.next.next = Node.new(12)
head.next.next.next = Node.new(7)
head.next.next.next.next = Node.new(11)

head.child = Node.new(4)
head.child.next = Node.new(20)
head.child.next.next = Node.new(13)
head.child.next.child = Node.new(2)
head.child.next.next.child = Node.new(16)
head.child.next.next.child.child = Node.new(3)

seven = head.next.next.next
seven.child = Node.new(17)
seven.child.next = Node.new(6)
seven.child.child = Node.new(9)
seven.child.child.next = Node.new(8)
seven.child.child.child = Node.new(19)
seven.child.child.child.next = Node.new(15)

h1 = flatten(head)

def _print(head)
  curr = head
  while curr != nil
    print "#{curr.key} "
    curr = curr.next
  end
end

_print(h1)

Node = Struct.new(:key, :next)

def pairwise_swap(head)
  return if head == nil || head.next == nil

  curr = head
  tmp = curr.next.next

  head = curr.next
  head.next = curr
  curr.next = tmp
  prev = curr
  curr = curr.next

  while curr != nil and curr.next != nil
    nxt = curr.next
    prev.next = nxt
    tmp = nxt.next
    nxt.next = curr
    curr.next = tmp
    prev = curr
    curr = curr.next
  end
  return head
end

head = Node.new(1)
head.next = Node.new(2)
head.next.next = Node.new(2)
head.next.next.next = Node.new(4)
head.next.next.next.next = Node.new(5)
head.next.next.next.next.next = Node.new(6)
head.next.next.next.next.next.next = Node.new(7)
head.next.next.next.next.next.next.next = Node.new(8)

def _p(node)
  while node != nil
    print node.key
    print ' '
    node = node.next
  end
  puts
end

puts "Original: "
_p(head)
head = pairwise_swap(head)
puts "Swapped: "
_p(head)

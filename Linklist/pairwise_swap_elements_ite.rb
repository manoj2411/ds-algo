Node = Struct.new(:key, :next)

def pairwise_swap(head)
  return head if head == nil || head.next == nil

  prev = nil
  curr = head
  head = head.next

  while curr != nil && curr.next != nil
    if prev
      prev.next = curr.next
    end

    prev = curr
    curr = curr.next.next
    prev.next.next = prev
  end
  prev.next = curr
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

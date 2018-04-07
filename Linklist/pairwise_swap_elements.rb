Node = Struct.new(:key, :next)

def pairwise_swap(node)
  return node if node == nil || node.next == nil

  nxt = node.next
  node.next = pairwise_swap(nxt.next)
  nxt.next = node
  return nxt

end

head = Node.new(1)
head.next = Node.new(2)
head.next.next = Node.new(2)
head.next.next.next = Node.new(4)
head.next.next.next.next = Node.new(5)
head.next.next.next.next.next = Node.new(6)
head.next.next.next.next.next.next = Node.new(7)
# head.next.next.next.next.next.next.next = Node.new(8)

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

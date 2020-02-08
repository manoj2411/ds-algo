Node = Struct.new(:item, :next)

def reverse(node)
  curr = node
  prev = nil
  while curr
    nxt = curr.next
    curr.next = prev
    prev = curr
    curr = nxt
  end
  prev
end

def print_list(node)
  while node != nil
    print "#{node.item} "
    node = node.next
  end
  puts
end


head = Node.new(1)
head.next = Node.new(3)
head.next.next = Node.new(5)
head.next.next.next = Node.new(7)
head.next.next.next.next = Node.new(8)
head.next.next.next.next.next = Node.new(9)

print "Original : "
print_list(head)
head = reverse(head)
print "Result : "
print_list(head)

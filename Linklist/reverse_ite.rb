Node = Struct.new(:item, :next)
def rev(node)
  curr = node
  start = nil
  while curr != nil
    tmp = curr
    curr = curr.next
    tmp.next = start
    start = tmp
  end

  return start
end

head = Node.new(1)
head.next = Node.new(3)
head.next.next = Node.new(5)
head.next.next.next = Node.new(7)
head.next.next.next.next = Node.new(8)
head.next.next.next.next.next = Node.new(9)

def to_p(head)
  curr = head
  while curr != nil
    print "#{curr.item} ->"
    curr = curr.next
  end
  puts
end

print "Old List : "
to_p(head)
head = rev(head)
puts
print "New List : "
to_p(head)

Node = Struct.new(:item, :next)

def rotate_by_k(head, k)
  return head if head.nil?

  curr = head
  i = 1
  rotation_point = nil
  while curr.next
    rotation_point = curr if i == k
    i += 1
    curr = curr.next
  end

  if rotation_point # it can be nil in case of k == Len(list) OR list has only 1 node. In this case nothing needs to be changed
    curr.next = head
    head = rotation_point.next
    rotation_point.next = nil
  end
  head
end

def pp(head)
  while head
    print "#{head.item} "
    head = head.next
  end
  puts
end

head = Node.new(2)
head.next = Node.new(4)
# head.next.next = Node.new(7)
# head.next.next.next = Node.new(8)
# head.next.next.next.next = Node.new(9)
# puts "Original list"
# pp head
# head = rotate_by_k(head, 2)
# puts "Rotated list"
# pp head

head2 = Node.new(1)
head2.next = Node.new(2)
head2.next.next = Node.new(3)
head2.next.next.next = Node.new(4)
head2.next.next.next.next = Node.new(5)
head2.next.next.next.next.next = Node.new(6)
head2.next.next.next.next.next.next = Node.new(7)
head2.next.next.next.next.next.next.next = Node.new(8)

# puts "Original list"
# pp head2
# head2 = rotate_by_k(head2, 4)
# puts "Rotated list"
# pp head2

head2.next.next = nil
puts "Original list"
pp head2
head2 = rotate_by_k(head2, 4)
puts "Rotated list"
pp head2

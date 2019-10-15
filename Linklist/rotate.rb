Node = Struct.new(:item, :next)

def rotate_by_k(head, k)
  curr = head
  i = 1
  tmp = nil
  while curr.next != nil
    tmp = curr if i == k
    i += 1
    curr = curr.next
  end

  if tmp
    curr.next = head
    head = tmp.next
    tmp.next = nil
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
head.next.next = Node.new(7)
head.next.next.next = Node.new(8)
head.next.next.next.next = Node.new(9)

head2 = Node.new(1)
head2.next = Node.new(2)
head2.next.next = Node.new(3)
head2.next.next.next = Node.new(4)
head2.next.next.next.next = Node.new(5)
head2.next.next.next.next.next = Node.new(6)
head2.next.next.next.next.next.next = Node.new(7)
head2.next.next.next.next.next.next.next = Node.new(8)


puts "Original list"
pp head
head = rotate_by_k(head, 3)
puts "Rotated list"
pp head

puts "Original list"
pp head2
head2 = rotate_by_k(head2, 4)
puts "Rotated list"
pp head2

head2.next.next = nil
puts "Original list"
pp head2
head2 = rotate_by_k(head2, 4)
puts "Rotated list"
pp head2

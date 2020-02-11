Node = Struct.new(:key, :next)

def sort_list(head)
  curr0 = head0 = Node.new
  curr1 = head1 = Node.new
  curr2 = head2 = Node.new
  curr = head

  while curr != nil
    case curr.key
    when 0
      curr0.next = curr
      curr = curr.next
      curr0 = curr0.next
    when 1
      curr1.next = curr
      curr = curr.next
      curr1 = curr1.next
    when 2
      curr2.next = curr
      curr = curr.next
      curr2 = curr2.next
    else
      raise 'Unexpected value'
    end
  end
  curr2.next = nil
  curr1.next = head2.next # assign dummy's next to curr1.next
  curr0.next = head1.next

  head0.next
end

def print_list(head)
  curr = head
  while curr != nil
    print "#{curr.key} "
    curr = curr.next
  end
  puts
end

head = Node.new(2)
head.next = Node.new(1)
head.next.next = Node.new(2)
head.next.next.next = Node.new(1)
head.next.next.next.next = Node.new(1)
head.next.next.next.next.next = Node.new(2)
head.next.next.next.next.next.next = Node.new(0)
head.next.next.next.next.next.next.next = Node.new(1)
head.next.next.next.next.next.next.next.next = Node.new(0)


print "Original List: "
print_list(head)
head = sort_list(head)
print "Sorted List: "
print_list(head)

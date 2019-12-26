Node = Struct.new(:item, :next)

def reverse_merge(lista, listb)
  a_curr = lista
  b_curr = listb
  result = nil

  while a_curr && b_curr
    if a_curr.item <= b_curr.item
      tmp = a_curr
      a_curr = a_curr.next
    else
      tmp = b_curr
      b_curr = b_curr.next
    end
    tmp.next = result
    result = tmp
  end

  while b_curr != nil
    tmp = b_curr
    b_curr = b_curr.next
    tmp.next = result
    result = tmp
  end

  while a_curr != nil
    tmp = a_curr
    a_curr = a_curr.next
    tmp.next = result
    result = tmp
  end

  result
end

def pp(node)
  while !node.nil?
    print "#{node.item} -> "
    node = node.next
  end
end

head1 = Node.new(10)
head1.next = Node.new(20,)
head1.next.next = Node.new(30)
head1.next.next.next = Node.new(40)
head1.next.next.next.next = Node.new(50)
head1.next.next.next.next.next = Node.new(60)


head2 = Node.new(5)
head2.next = Node.new(22)
head2.next.next = Node.new(25)
head2.next.next.next = Node.new(32)

result = reverse_merge(head1, head2)

puts 'Printing Result'
pp(result)

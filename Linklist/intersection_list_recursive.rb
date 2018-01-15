Node = Struct.new(:key, :next)
def inter_section_recur(node1, node2)
  return nil if node1.nil? or node2.nil?

  if node1.key == node2.key
    node = Node.new(node2.key)
    node.next = inter_section_recur(node1.next, node2.next)
    return node
  elsif node1.key < node2.key
    return inter_section_recur(node1.next, node2)
  else
    return inter_section_recur(node1, node2.next)
  end
end

def print_list(head)
  curr = head
  print "\nList: "
  while curr != nil
    print "#{curr.key} "
    curr = curr.next
  end
end

head1 = Node.new(1)
head1.next = Node.new(2)
head1.next.next = Node.new(3)
head1.next.next.next = Node.new(4)
head1.next.next.next.next = Node.new(6)

head2 = Node.new(2)
head2.next = Node.new(4)
head2.next.next = Node.new(5)
head2.next.next.next = Node.new(6)
print_list(head1)
print_list(head2)
head = inter_section_recur(head1, head2)
print_list(head)

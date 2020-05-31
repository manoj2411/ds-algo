Node = Struct.new(:item, :next)

# Without using dummy node/extra space


def merge_inplace(list_a, list_b)
  if list_b.nil?
    return list_a
  elsif list_a.nil?
    return list_b
  elsif list_a.item > list_b.item
    list_a, list_b = list_b, list_a
  end
  # Now we are sure that list_a has smaller first element then list_b

  _curr = list_a
  _next = list_a.next

  while list_b != nil
    if _next == nil
      _curr.next = list_b
      list_b = nil
      break
    end

    if _next.item <= list_b.item
      _curr = _next
      _next = _next.next
    else
      _curr.next = list_b
      list_b = list_b.next
      _curr = _curr.next
      _curr.next = _next
    end
  end
  list_a
end

def print_list(node)
  while not node.nil?
    print "#{node.item} "
    node = node.next
  end
  puts
end


head1 = Node.new(10)
head1.next = Node.new(20)
head1.next.next = Node.new(30)
# head1.next.next.next = Node.new(40)
# head1.next.next.next.next = Node.new(50)
# head1.next.next.next.next.next = Node.new(60)

head2 = Node.new(5)
head2.next = Node.new(22)
# head2.next.next = Node.new(25)
# head2.next.next.next = Node.new(32)

# puts "List1"
# print_list(head1)
# puts "List2"
# print_list(head2)
# result = merge_inplace(head1, head2)
# puts "Printing Result"
# print_list(result)

#  ======================
#  = Alternate approach =
#  ======================

def merge_util(result, other)
  while result.next && other
    if other.item > result.next.item
      result = result.next
    else
      tmp = result.next
      result.next = other
      other = other.next
      result = result.next
      result.next = tmp
    end
  end
  result.next = other if other
end


def merge(list_a, list_b)
  if list_a.nil?
    list_b
  elsif list_b.nil?
    list_a
  elsif list_a.item <= list_b.item
    merge_util(list_a, list_b)
    list_a
  else
    merge_util(list_b, list_a)
    list_b
  end
end

new_head = merge(head1, head2)

puts "Printing Result"
print_list(new_head)

Node = Struct.new(:item, :next)

# Without using dummy node/extra space
def reverse_merge_new(a,b)
  if a.item <= b.item
    list = a
    extra = b
  else
    list = b
    extra = a
  end

  prev = list
  curr = list.next

  while extra != nil
    if curr == nil
      prev.next = extra
      extra = nil
      break
    end

    if curr.item <= extra.item
      prev = curr
      curr = curr.next
    else
      prev.next = extra
      extra = extra.next
      prev = prev.next
      prev.next = curr
    end
  end
  return list
end

def print_list(node)
  curr = node
  while !curr.nil?
    print "#{curr.item} -> "
    curr = curr.next
  end
  puts
end


l1 = Node.new(10, nil)
l2 = Node.new(20, nil)
l3 = Node.new(30, nil)
l4 = Node.new(40, nil)
l5 = Node.new(50, nil)
l6 = Node.new(60, nil)

l1.next = l2
l2.next = l3
l3.next = l4
l4.next = l5
l5.next = l6

m1 = Node.new(5, nil)
m2 = Node.new(22, nil)
m3 = Node.new(25, nil)
m4 = Node.new(32, nil)
m1.next = m2
m2.next = m3
m3.next = m4

puts "List1"
print_list(l1)

puts "List2"
print_list(m1)

# result = reverse_merge_new(l1, m1)

# puts "Printing Result"
# print_list(result)

#  ======================
#  = Alternate approach =
#  ======================

def merge_util(l1, l2)
  curr = l1
  c2 = l2
  while curr.next != nil && c2 != nil
    if curr.next.item > c2.item
      nxt = curr.next
      curr.next = c2
      c2 = c2.next
      curr.next.next = nxt
    end
    curr = curr.next
  end
  if curr.next == nil
    curr.next = c2
  end
  return l1
end

def merge(h1, h2)
  if h1 == nil and h2 == nil
    return nil
  elsif h1 == nil
    return h2
  elsif h2 == nil
    return h1
  end

  if h1.item < h2.item
    merge_util(h1, h2)
  else
    merge_util(h2, h1)
  end
end

result = merge(l1, m1)

puts "Printing Result"
print_list(result)

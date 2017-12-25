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

result = reverse_merge_new(l1, m1)

puts "Printing Result"
curr = result
while !curr.nil?
  print "#{curr.item} -> "
  curr = curr.next
end

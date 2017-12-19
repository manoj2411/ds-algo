Node = Struct.new(:item, :next)

def get_length(list)
  len = 0
  curr = list
  while curr != nil
    len += 1
    curr = curr.next
  end
  return len
end

def get_intersection(a, b)
  a_len = get_length(a)
  b_len = get_length(b)

  if a_len > b_len
    big = a
    small = b
  else
    big = b
    small = a
  end
  distance = (a_len - b_len).abs
  distance.times { big = big.next}

  while small != nil
    if small == big
      puts "Lists are intersecting on node #{small.item}"
      return small
      break
    end
    small = small.next
    big = big.next
  end
end


l1 = Node.new(3, nil)
l2 = Node.new(6, nil)
l3 = Node.new(9, nil)
l4 = Node.new(15, nil)
l5 = Node.new(30, nil)

l1.next = l2
l2.next = l3
l3.next = l4
l4.next = l5

m1 = Node.new(10, nil)
m1.next = l4

result = get_intersection(l1, m1)

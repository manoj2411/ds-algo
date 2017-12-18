require "byebug"
Node = Struct.new(:item, :next)

def reverse_merge(a, b)
  acurr = a
  bcurr = b
  result = nil
  while true
    if acurr.nil?
      while bcurr != nil
        tmp = bcurr
        bcurr = bcurr.next
        tmp.next = result
        result = tmp
      end
      break
    elsif bcurr.nil?
      while acurr != nil
        tmp = acurr
        acurr = acurr.next
        tmp.next = result
        result = tmp
      end
      break
    end

    if acurr.item <= bcurr.item
      tmp = acurr
      acurr = acurr.next
    else
      tmp = bcurr
      bcurr = bcurr.next
    end
    tmp.next = result
    result = tmp
  end
  result
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

result = reverse_merge(l1, m1)

puts "Printing Result"
curr = result
while !curr.nil?
  print "#{curr.item} -> "
  curr = curr.next
end

# debugger
# true

Node = Struct.new(:key, :next)

def palindrome?(l1)
  mid = get_mid(l1)
  l2 = mid.next
  l2 = reverse(l2)

  res = is_same?(l2, l1)

  l2 = reverse(l2)
  mid.next = l2
  return res
end

def get_mid(head)
  return nil if head == nil

  slow = head
  fast = head.next
  while fast != nil
    fast = fast.next
    if fast != nil
      fast = fast.next
      slow = slow.next
    end
  end
  return slow
end

def reverse(node)
  if node == nil || node.next == nil
    return node
  end

  start = reverse(node.next)
  node.next.next = node
  node.next = nil
  return start

end

def is_same?(l1, l2)
  c1 = l1
  c2 = l2

  while c1 != nil && c2 != nil
    if c1.key != c2.key
      return false
    end
    c1 = c1.next
    c2 = c2.next
  end
  return c1 == nil
end

def pp(head)
  print "List: "
  while head != nil
    print head.key
    print ' '
    head = head.next
  end
  puts
end


head = Node.new 'a'
head.next = Node.new 'c'
head.next.next = Node.new 'b'
head.next.next.next = Node.new 'b'
head.next.next.next.next = Node.new 'c'
head.next.next.next.next.next = Node.new 'a'


pp head
puts "palindrome? #{palindrome? head}"
pp head


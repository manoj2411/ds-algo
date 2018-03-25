Node = Struct.new :key, :next

def is_palindrome?(head)
  count = count(head)
  mid = count / 2 + (count % 2)
  i = 1
  curr = head
  while i < mid
    curr = curr.next
    i += 1
  end

  mid_node = curr
  curr.next = reverse(curr.next)
  curr = curr.next
  fcurr = head

  flag = true
  while curr != nil
    if curr.key != fcurr.key
      flag = false
      break
    end
    curr = curr.next
    fcurr = fcurr.next
  end
  mid_node.next = reverse(mid_node.next)

  return flag
end

def count(node)
  return 0 if node.nil?

  count = 0
  while node != nil
    count = count += 1
    node = node.next
  end
  return count
end

def reverse(node)
  return node if node.nil? || node.next.nil?

  start = reverse(node.next)
  node.next.next = node
  node.next = nil
  return start
end

def _p(node)
  while node != nil
    print "#{node.key} "
    node = node.next
  end
  puts
end

head = Node.new(1)
head.next = Node.new(2)
head.next.next = Node.new(3)
head.next.next.next = Node.new(3)
head.next.next.next.next = Node.new(2)
head.next.next.next.next.next = Node.new(11)

puts 'List:'
_p(head)
puts "Palindrome: #{is_palindrome?(head)}"
puts 'List:'
_p(head)


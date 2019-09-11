def pp(node)
  curr = node
  res = []
  while curr != nil
    res << curr.key
    curr = curr.next
  end
  puts res.join(" -> ")
end

Node = Struct.new(:key, :next)

def reverse_in_group(head, k)
  new_head = nil
  prev_h = nil
  curr = head

  while curr != nil
    curr_h = curr
    i = 1
    prev = nil

    while i <= k && curr != nil
      tmp = curr.next
      curr.next = prev
      prev = curr
      curr = tmp
      i += 1
    end
    if prev_h.nil?
      new_head = prev
      prev_h = curr_h
    else
      prev_h.next = prev
      prev_h = curr_h
    end
  end

  new_head
end


def helper(node, k)
  if node.nil? || node.next.nil? || k == 1
    return node
  end
  res = helper(node.next, k - 1)
  node.next.next = node
  node.next = nil
  res
end

head = Node.new(1)
head.next = Node.new 2
head.next.next = Node.new 3
head.next.next.next = Node.new 4
head.next.next.next.next = Node.new 5
head.next.next.next.next.next = Node.new 6
head.next.next.next.next.next.next = Node.new 7
# head.next.next.next.next.next.next.next = Node.new 8

puts "Original list: "
pp head
head = reverse_in_group head, 4
puts "Reversed list:"
pp head

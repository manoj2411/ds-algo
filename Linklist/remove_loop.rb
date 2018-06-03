Node = Struct.new(:key, :next)

def find_cycel_len(node)
  return 0 if node == nil
  curr = node.next
  count = 1
  while curr != node
    count += 1
    curr = curr.next
  end
  return count
end

def remove_cycle(head)
  if head == nil
    return
  elsif head.next == head
    head.next = nil
    return
  end

  slow = head
  fast = head.next

  while fast != nil && fast != slow
    fast = fast.next
    if fast != nil
      fast = fast.next
      slow = slow.next
    end
  end

  return if fast == nil

  len = find_cycel_len(fast)

  # Alternate implementation
  # n = find_cycel_len(fast)
  # n = find_loop_length(fast)
  # slow = head
  # fast = head
  # (n - 1).times { fast = fast.next }

  # while true
  #   if fast.next == slow
  #     puts "Cycle: #{fast.key} -> #{slow.key}"
  #     fast.next = nil
  #     return
  #   end
  #   slow = slow.next
  #   fast = fast.next
  # end

  fast = head
  prev = nil
  len.times do
    prev = fast
    fast = fast.next
  end

  slow = head

  while slow != fast
    prev = fast
    fast = fast.next
    slow = slow.next
  end
  puts "Cycle: #{prev.key} -> #{prev.next.key}"
  prev.next = nil
end

def pp node
  while node != nil
    print node.key
    print ' '
    node = node.next
  end
  puts
end

head = Node.new 1
head.next = Node.new 2
head.next.next = Node.new 3
head.next.next.next = Node.new 4
head.next.next.next.next = Node.new 5
head.next.next.next.next.next = Node.new 6
head.next.next.next.next.next.next = Node.new 7
head.next.next.next.next.next.next.next = Node.new 8
head.next.next.next.next.next.next.next.next = head.next.next#.next.next.next.next.next

remove_cycle head

pp head

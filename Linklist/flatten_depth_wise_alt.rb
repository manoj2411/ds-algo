Node = Struct.new(:key, :next, :down)


def util(node, store)
  return if node == nil

  if node.next == nil and node.down == nil
    store[:last] = node
    return
  end

  if node.down == nil
    util(node.next, store)
    return
  end

  nxt = node.next
  node.next = node.down
  util(node.down, store)
  # if nxt
    store[:last].next = nxt
    util nxt, store
  # end
end

def flatten(root)
  store = {last: nil}
  util(root, store)
  root
end

def flatten2(node)
  return node if node.nil? || (node.next.nil? && node.down.nil?)

  if node.down.nil?
    return flatten(node.next)
  end

  nxt = node.next
  node.next = node.down
  last = flatten(node.down)
  if nxt
    last.next = nxt
    return flatten(nxt)
  else
    return last
  end
end


def pp(node)
  while node != nil
    print node.key
    print ' '
    node = node.next
  end
  puts
end



head = Node.new(1)
head.next = Node.new(2)
head.next.down = Node.new(7)
head.next.down.down = Node.new(9)
head.next.down.down.down = Node.new(14)
head.next.down.down.down.down = Node.new(15)
head.next.down.down.down.down.next = Node.new(23)
head.next.down.down.down.down.next.down = Node.new(24)

head.next.down.next = Node.new(8)
head.next.down.next.down = Node.new(16)
head.next.down.next.down.down = Node.new(17)
head.next.down.next.down.down.next = Node.new(18)
head.next.down.next.down.down.next.next = Node.new(19)
head.next.down.next.down.down.next.next.next = Node.new(20)
head.next.down.next.down.down.next.next.next.down = Node.new(21)

head.next.down.next.next = Node.new(10)
head.next.down.next.next.down = Node.new(11)
head.next.down.next.next = Node.new(12)

head.next.next = Node.new(3)
head.next.next.next = Node.new(4)


puts "Original: "
pp head

puts "Flattened: "
flatten(head)
pp head


Node = Struct.new(:key, :left, :right, :next)

def connect_next_pointers(node)
  next_level = nil
  curr = node

  while curr != nil
    if curr.left.nil? && curr.right.nil?
      curr = curr.next
      if curr == nil
        curr = next_level
        next_level = nil
      end
      next
    end

    if curr.left
      curr.left.next = curr.right
    end

    next_level ||= curr.left || curr.right
    child = curr.right || curr.left

    next_non_leaf = curr.next
    while next_non_leaf != nil
      if next_non_leaf.left || next_non_leaf.right
        break
      end
      next_non_leaf = next_non_leaf.next
    end

    if next_non_leaf
      child.next = next_non_leaf.left || next_non_leaf.right
    end

    curr = curr.next
    if curr == nil
      curr = next_level
      next_level = nil
    end
  end
end

def print_levels(root)
  curr = root
  while curr != nil
    _next_level = nil
    while curr != nil
      print("#{curr.key} ")
      _next_level ||= curr.left || curr.right
      curr = curr.next
    end
    curr = _next_level
  end
  puts
end

root = Node.new(10)
root.left = Node.new(8)
root.left.left = Node.new(3)
root.right = Node.new(2)
root.right.right = Node.new(90)
# root.left = Node.new(20)
# root.left.left = Node.new(40)
# root.left.right = Node.new(60)
# root.right = Node.new(30)

connect_next_pointers(root)
print_levels(root)

# puts root

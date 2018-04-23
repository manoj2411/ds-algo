Node = Struct.new(:key, :left, :right, :next)


def get_next_non_leaf(node)
  while node != nil
    if node.left || node.right
      return node
    end
    node = node.next
  end
  return nil
end

def connect_next_pointers(node)
  next_level = nil
  curr = node

  while curr != nil
    # traverse & process level nodes
    if curr.left
      curr.left.next = curr.right
    end

    # sets next level if not set
    next_level ||= curr.left || curr.right

    # child whose next is not set. If curr has no right means child will be curr.left
    # bcz its next is still nil in this case
    child = curr.right || curr.left
    if child
      next_non_leaf = get_next_non_leaf(curr.next)
      if next_non_leaf
        child.next = next_non_leaf.left || next_non_leaf.right
      end
    end

    curr = curr.next
    # check if we reached to end of level
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

# root = Node.new(10)
# root.left = Node.new(8)
# root.left.left = Node.new(3)
# root.right = Node.new(2)
# root.right.right = Node.new(90)
# root.left = Node.new(20)
# root.left.left = Node.new(40)
# root.left.right = Node.new(60)
# root.right = Node.new(30)
head = Node.new(10)
head.left = Node.new(3)
head.left.left = Node.new(4)
head.left.left.left = Node.new(6)
head.left.right = Node.new(1)
head.left.right.right = Node.new(10)
head.right = Node.new(5)
head.right.left = Node.new(7)
head.right.right = Node.new(11)
head.right.right.right = Node.new(12)

connect_next_pointers(head)
print_levels(head)


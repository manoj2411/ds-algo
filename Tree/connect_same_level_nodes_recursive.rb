Node = Struct.new(:key, :left, :right, :next)
def connect_next_pointers(root)
  return if root.nil? || (root.left.nil? && root.right.nil?)

  if root.left
    root.left.next = root.right
  end

  child = root.right || root.left

  if child
    next_non_leaf = find_next_non_leaf(root.next)
    if next_non_leaf
      child.next = next_non_leaf.left || next_non_leaf.right
    end
  end
  connect_next_pointers(root.next)
  connect_next_pointers(root.left)
end

def find_next_non_leaf(node)
  while node != nil
    return node if node.left || node.right
    node = node.next
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

Node = Struct.new(:key, :left, :right)

def print_left_view(node, arr, level)
  return if node.nil?

  if arr[level] == nil
    print " #{node.key} "
    arr[level] = true
  end
  print_left_view(node.left, arr, level + 1) if node.left
  print_left_view(node.right, arr, level + 1) if node.right
end

# Node.new()

root = Node.new(4)
root.left = Node.new(5)
root.right = Node.new(2)
root.right.left = Node.new(3)
root.right.right = Node.new(1)
root.right.right.left = Node.new(11)
root.right.right.left.right = Node.new(22)
root.right.left.left = Node.new(6)
root.right.left.right = Node.new(7)

print_left_view(root, [], 0)

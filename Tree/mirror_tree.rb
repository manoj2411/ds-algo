Node = Struct.new(:key, :left, :right)

def mirror(node)
  return if node == nil

  left = node.left
  right = node.right
  node.left = right
  node.right = left
  mirror(left)
  mirror(right)
end

def print_preorder(node)
  return if node == nil
  print " #{node.key} "
  print_preorder(node.left)
  print_preorder(node.right)
end

root = Node.new(4)
root.left = Node.new(2)
root.left.left = Node.new(1)
root.left.right = Node.new(3)
root.right = Node.new(5)


puts "Before - Preorder traversal:"
print_preorder(root)

mirror(root)

puts
puts "After - Preorder traversal:"
print_preorder(root)

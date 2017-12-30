Node = Struct.new(:key, :left, :right)

def double_tree(node)
  return if node == nil

  left = node.left
  node.left = Node.new(node.key, left)
  double_tree(left)
  double_tree(node.right)

end

def print_tree(node)
  return if node == nil
  print " #{node.key} "
  print_tree(node.left)
  print_tree(node.right)
end

root = Node.new(1)
root.left = Node.new(2)
root.right = Node.new(3)
root.left.left = Node.new(4)
root.left.right = Node.new(5)

puts "Original Tree (Preorder)"
print_tree(root)

double_tree(root)

puts
puts 'Modified Tree (Preorder)'
print_tree(root)

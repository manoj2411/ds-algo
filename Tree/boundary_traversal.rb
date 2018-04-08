Node = Struct.new(:key, :left, :right)

def print_boundary(root)
  return if root == nil

  print "#{root.key} "
  print_left_boundary(root.left)
  print_leafs(root)
  print_right_boundary(root.right)
end

def print_left_boundary(node)
  return if node == nil || (node.left == nil && node.right == nil)
  print "#{node.key} "
  print_left_boundary(node.left || node.right)
end

def print_leafs(node)
  return if node == nil

  if node.left == nil and node.right == nil
    print "#{node.key} "
    return
  end
  print_leafs(node.left)
  print_leafs(node.right)
end

def print_right_boundary(node)
  return if node == nil || (node.left.nil? && node.right.nil?)
  print_right_boundary(node.right || node.left)
  print "#{node.key} "
end

root =  Node.new(20)
root.left =  Node.new(8)
root.left.left =  Node.new(4)
root.left.right =  Node.new(12)
root.left.right.left =  Node.new(10)
root.left.right.right =  Node.new(14)
# root.right =  Node.new(22)
# root.right.right =  Node.new(25)
print_boundary(root)
puts

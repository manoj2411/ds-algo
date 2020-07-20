Node = Struct.new(:key, :left, :right)

def print_left_view(node)
  print_left_view_helper(node, [0], 1)
  puts
end

def print_left_view_helper(node, max_level, curr_level)
  return if node.nil?

  if max_level[0] < curr_level
    print "#{node.key} "
    max_level[0] = curr_level
  end

  print_left_view_helper(node.left, max_level, curr_level + 1)
  print_left_view_helper(node.right, max_level, curr_level + 1)
end




root = Node.new(4)
root.left = Node.new(5)
root.right = Node.new(2)
root.right.left = Node.new(3)
root.right.right = Node.new(1)
root.right.right.left = Node.new(11)
root.right.right.left.right = Node.new(22)
root.right.left.left = Node.new(6)
root.right.left.right = Node.new(7)

print_left_view(root) # 4 5 3 6 22

root = Node.new(1)
root.left = Node.new(2)
root.right = Node.new(3)

root.left.right = Node.new(4)
root.left.right.right = Node.new(5)
root.left.right.right.right = Node.new(6)
print_left_view(root) # 1 2 4 5 6

Node = Struct.new(:key, :left, :right)

def same_trees?(node1, node2)
  if node1 == nil && node2 == nil
    return true
  elsif node1 == nil || node2 == nil
    return false
  end

  return node1.key == node2.key && same_trees?(node1.left, node2.left) &&
         same_trees?(node1.right, node2.right)
end

def subtree?(root1, root2)
  if root1 == nil && root2 == nil
    return true
  end

  if root1 == nil || root2 == nil
    return false
  end

  if root1.key != root2.key
    return subtree?(root1, root2.left) || subtree?(root1, root2.right)
  else
    return same_trees?(root1, root2)
  end
end


# root2 = Node.new(1)
# root2.left = Node.new(2)
# root2.right = Node.new(3)
# root2.right.left = Node.new(4)
# root2.right.right = Node.new(6)
# root2.right.right.right = Node.new(7)

# root1 = Node.new(3)
# root1.left = Node.new(4)
# root1.right = Node.new(6)
# root1.right.right = Node.new(7)

root2 = Node.new(26)
root2.left = Node.new(10)
root2.right = Node.new(3)
root2.right.right = Node.new(3)
root2.left.left = Node.new(4)
root2.left.right = Node.new(6)
root2.left.left.right = Node.new(30)
root2.right.right.right = Node.new(7)

root1 = Node.new(10)
root1.left = Node.new(4)
root1.left.right = Node.new(30)
root1.right = Node.new(6)
# root1.right.left = Node.new(6)
# root

puts "Is tree1 is subtree of tree2 #{subtree?(root1, root2)}"

Node = Struct.new(:key, :left, :right)

def same_trees?(node1, node2)
  if node1 == nil && node2 == nil
    return true
  elsif (node1 != nil && node2 != nil)
    return node1.key == node2.key &&
          same_trees?(node1.left, node2.left) &&
          same_trees?(node1.right, node2.right)
  else
    return false
  end
end

root1 = Node.new(1)
root1.left = Node.new(2)
root1.right = Node.new(3)
root1.left.left = Node.new(4)
root1.left.right = Node.new(5)
root1.left.right.left = Node.new(11)

root2 = Node.new(1)
root2.left = Node.new(2)
root2.right = Node.new(3)
root2.left.left = Node.new(4)
root2.left.right = Node.new(5)
root2.left.right.left = Node.new(11)


puts "Trees are same? #{same_trees?(root1, root2)}"

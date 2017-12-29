# Given a tree and a sum, returns true if there is a path from the root
#  down to a leaf, such that adding up all the values along the path
#  equals the given sum.

Node = Struct.new(:key, :left, :right)

def has_path_sum?(node, sum, curr_sum = 0)
  if node == nil
    return false
  end

  if node.left == nil and node.right == nil
    return curr_sum + node.key == sum
  end

  return (has_path_sum?(node.left, sum, curr_sum + node.key) ||
          has_path_sum?(node.right, sum, curr_sum + node.key))
end

root = Node.new(5)
root.left  = Node.new(4)
root.right = Node.new(8)
root.left.left = Node.new(11)
root.left.left.left = Node.new(7)
root.left.left.right = Node.new(2)
root.right.left = Node.new(13)
root.right.right = Node.new(4)
root.right.right.right = Node.new(1)


puts " Has sum? : #{has_path_sum?(root, 18)}"

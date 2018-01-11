Node = Struct.new(:key, :left, :right)

module BinaryTree
  module_function

  def get_leaves_count(node)
    return 0 if node == nil
    return 1 if node.left == nil && node.right == nil

    left_leaves = get_leaves_count(node.left)
    right_leaves = get_leaves_count(node.right)
    return left_leaves + right_leaves
  end

end


# root = Node.new(1)
# root.left = Node.new(10)
# root.right = Node.new(39)
# root.left.left = Node.new(5)
root = Node.new(10)
root.left = Node.new(20)
root.left.left = Node.new(40)
root.left.right = Node.new(60)
root.right = Node.new(30)
# root.left.left = Node.new(5)

puts "Height of tree is: #{BinaryTree.get_leaves_count(root)}"

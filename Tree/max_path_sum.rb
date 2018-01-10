Node = Struct.new(:key, :left, :right)
module BinaryTree

  module_function
  Store = Struct.new(:sum)

  def max_path_sum(root)
    store = Store.new -Float::INFINITY
    max_sum(root, store)
    return store.sum
  end

  # protected
  def max_sum(node, store)
    return 0  if node == nil
    return node.key if node.left.nil? && node.right.nil?

    left_sum = max_sum(node.left, store) if node.left
    right_sum = max_sum(node.right, store) if node.right

    store.sum = [store.sum, [left_sum, right_sum, node.key].compact.reduce(:+)].max
    return [left_sum, right_sum].compact.max + node.key
  end

end

root = Node.new(-15)
root.left = Node.new(5)
root.right = Node.new(6)
root.left.left = Node.new(-8)
root.left.right = Node.new(1)
root.right.left = Node.new(3)
root.right.right = Node.new(9)
root.right.right.right = Node.new(-1)
# root.right.right.right.left = Node.new(4)
# root.right.right.right.right = Node.new(-1)
# root.right.right.right.right.left = Node.new(10)

puts BinaryTree.max_path_sum(root)

Node = Struct.new(:key, :left, :right)
module BinaryTree
  module_function
  Store = Struct.new(:height)

  def max_height(node, store)
    if node.nil?
      return 0
    end

    left_height = max_height(node.left, store)
    right_height = max_height(node.right, store)

    store.height = [left_height + right_height + 1, store.height].max

    return [left_height, right_height].max + 1
  end

  def calculate_diameter(root)
    store = Store.new 0
    max_height(root, store)
    return store.height
  end
end

root = Node.new(0)
root.left = Node.new(1)
root.left.left = Node.new(11)
root.left.right = Node.new(13)
root.right = Node.new(2)
# root.right.right = Node.new(3)

puts BinaryTree.calculate_diameter(root)

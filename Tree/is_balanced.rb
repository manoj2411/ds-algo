Node = Struct.new(:key, :left, :right)

def is_balanced?(root)
  return true if root.nil?
  store = [false]
  is_balanced_util(root, store)
  return !store.first
end

def is_balanced_util(node, store)
  return 0 if node == nil || store[0]

  left_height = is_balanced_util(node.left, store)
  right_height = is_balanced_util(node.right, store)

  if (left_height - right_height).abs > 1
    store[0] = true
    return 0
  end

  return [left_height, right_height].max + 1

end

root = Node.new(1)
root.left = Node.new(2)
root.left.left = Node.new(4)
root.left.left.left = Node.new(7)
root.left.right = Node.new(5)
root.right = Node.new(3)
root.right.left = Node.new(6)

if is_balanced?(root)
  puts 'Tree is balanced'
else
  puts 'Tree is not balanced'
end

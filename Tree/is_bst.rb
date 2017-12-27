Node = Struct.new(:key, :left, :right)

def is_bst?(node)
  return true if node == nil

  left = node.left
  right = node.right
  result = true

  if left && left.key > node.key
    result = false
  elsif right && right.key < node.key
    result = false
  end

  return result && is_bst?(left) && is_bst?(right)
end

root = Node.new(4)
root.left = Node.new(2)
root.right = Node.new(5)
# root.right.left = Node.new(6)
root.left.left = Node.new(1)
root.left.right = Node.new(3)


puts "is BTS: #{is_bst?(root)}"



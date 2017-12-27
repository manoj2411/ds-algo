Node = Struct.new(:key, :left, :right)

# Wrong implementation
# def is_bst?(node)
#   return true if node == nil

#   left = node.left
#   right = node.right
#   result = true

#   if left && left.key > node.key
#     result = false
#   elsif right && right.key < node.key
#     result = false
#   end

#   return result && is_bst?(left) && is_bst?(right)
# end

def isBSTUtil?(node, min, max)
  return true if node == nil
  return false if node.key < min || node.key > max

  if node.key < min || node.key > max
    return false
  end

  return isBSTUtil?(node.left, min, node.key) &&
         isBSTUtil?(node.right, node.key - 1, max)

end

  MIN = -99999
  MAX = 99999
def isBst?(node)

  return isBSTUtil?(node, MIN, MAX)
end

# root = Node.new(13)
# root.left = Node.new(2)
# root.right = Node.new(15)
# # root.right.left = Node.new(6)
# root.left.left = Node.new(1)
# root.left.right = Node.new(4)

# root = Node.new(4);
# root.left = Node.new(2);
# root.right = Node.new(5);
# root.left.left = Node.new(1);
# root.left.right = Node.new(3)

root = Node.new(3);
root.left        = Node.new(2);
root.right       = Node.new(5);
root.left.left  = Node.new(1);
root.left.right = Node.new(4)


puts "is BTS: #{isBst?(root)}"



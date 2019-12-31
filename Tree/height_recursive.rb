Node = Struct.new(:key, :left, :right)

def height(node)
  return 0 if node == nil
  [height(node.left), height(node.right)].max + 1
end


root = Node.new(1)
root.left = Node.new(2)
root.right = Node.new(3)
root.left.left = Node.new(4)
root.left.right = Node.new(5)
root.left.right.left = Node.new(15)

puts "Height of Binary tree is: #{height(root)}"

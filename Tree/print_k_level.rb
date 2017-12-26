Node = Struct.new(:item, :left, :right)

def print_k_level(node, k)
  if node == nil
    return
  end

  if k == 0
    print " #{node.item} "
    return
  end
  print_k_level(node.left, k - 1)
  print_k_level(node.right, k - 1)
end


root = Node.new('A')
root.left = Node.new('B')
root.right = Node.new('C')
root.left.left = Node.new('D')
root.left.left.left = Node.new('H')
root.right.left = Node.new('E')
root.right.right = Node.new('F')
root.right.left.left = Node.new('G')

puts "Print level 2 nodes: "
print_k_level(root, 2)

Node = Struct.new(:key, :left, :right)

def print_level_of_key(node, key, level = 0)
  if node == nil
    return
  end

  if key == node.key
    puts " Level of #{node.key} is: #{level}"
    return
  end
  print_level_of_key(node.left, key, level + 1)
  print_level_of_key(node.right, key, level + 1)
end


root = Node.new('A')
root.left = Node.new('B')
root.right = Node.new('C')
root.left.left = Node.new('D')
root.left.left.left = Node.new('H')
root.right.left = Node.new('E')
root.right.right = Node.new('F')
root.right.left.left = Node.new('G')

print_level_of_key(root, 'G')

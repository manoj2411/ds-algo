Node = Struct.new(:key, :left, :right)


def print_paths_util(node, arr)
  return if node == nil

  if node.left == nil and node.right == nil
    puts (arr + [node.key]).join(', ')
  end

  print_paths_util(node.left, arr + [node.key])
  print_paths_util(node.right, arr + [node.key])
end

def print_paths(node)
  print_paths_util(node, [])
end


root = Node.new(5)
root.left = Node.new(4)
root.left.left = Node.new(11)
root.left.left.left = Node.new(7)
root.left.left.right = Node.new(2)
root.right = Node.new(8)
root.right.left = Node.new(13)
root.right.right = Node.new(4)
root.right.right.right = Node.new(1)

print_paths(root)

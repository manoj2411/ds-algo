Node = Struct.new(:key, :left, :right)

def find_closest(node, k)
  raise 'Empty tree' if node == nil
  diff = node.key - k

  if node.key == k
    return node.key
  elsif node.key > k
    if node.left == nil || (node.left.key - k).abs > diff.abs
      return node.key
    else
      find_closest(node.left, k)
    end
  else
    if node.right == nil || (node.right.key - k).abs > (diff).abs
      return node.key
    else
      find_closest(node.right, k)
    end
  end
end

root = Node.new(9)
root.left = Node.new(4)
root.left.left = Node.new(3)
root.left.right = Node.new(6)
root.left.right.left = Node.new(5)
root.left.right.right = Node.new(7)
root.right = Node.new(17)
root.right.right = Node.new(22)
root.right.right.left = Node.new(20)

for k in [4, 18, 21, 0, 100, 11,13,15]
  puts "k: #{k} \t Res: #{find_closest root, k}"
end

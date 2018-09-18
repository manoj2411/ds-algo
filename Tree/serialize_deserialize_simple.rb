Node = Struct.new(:key, :left, :right)

def serialize(root)
  arr = []
  shelper(root, arr)
  return arr
end

def shelper(root, arr)
  if root == nil
    arr << -1
    return
  end
  # push in arr preorder
  arr << root.key
  shelper(root.left, arr)
  shelper(root.right, arr)
end

def deserialize(arr)
  return if arr == nil || arr.empty?
  hs = { i: 0}
  dhelper(arr, hs)
end

def dhelper(arr, info)
  i = info[:i]
  info[:i] += 1
  return nil if arr[i] == -1

  node = Node.new arr[i]
  node.left = dhelper(arr, info)
  node.right = dhelper(arr, info)
  return node
end

def pp(node)
  return if node == nil

  print node.key
  print ' '
  pp node.left
  pp node.right
end



root = Node.new 20
root.left = Node.new 8
root.left.left = Node.new 4
root.left.left.right = Node.new 12
root.left.left.right.right = Node.new 10
root.right = Node.new 22
root.right.right = Node.new 18
root.right.right.left = Node.new 14

serialized = serialize( root)
puts "Serialized: #{serialized}"

puts "Deserialize..."
root = deserialize(serialized)
pp root
puts



root = Node.new 20
root.left = Node.new 8
root.left.left = Node.new 4
root.left.right = Node.new 12
root.left.right.left = Node.new 10
root.left.right.right = Node.new 14
root.right = Node.new 22
root.right.right = Node.new 18

serialized = serialize( root)
puts "Serialized: #{serialized}"

puts "Deserialize..."
root = deserialize(serialized)
pp root
puts


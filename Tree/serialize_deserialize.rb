Node = Struct.new(:key, :left, :right)

def serialize(root)
  arr = []
  shelper(root, arr)
  return arr
end

def shelper(root, arr)
  return if root == nil
  # push in arr preorder
  arr << root.key
  if root.left == nil && root.right == nil
    arr << -2
  elsif root.left == nil
    arr << -1
    shelper(root.right, arr)
  elsif root.right == nil
    shelper(root.left, arr)
    arr << -1
  else
    shelper(root.left, arr)
    shelper(root.right, arr)
  end
end

def deserialize(arr)
  if arr == nil || arr.empty?
    return
  end
  root = Node.new(arr[0])
  hs = { i: 1}
  r = arr.length
  dhelper(root, hs, r, arr)
  return root
end

def dhelper(node, hs, r, arr)
  if node == nil || hs[:i] == r
    return nil
  end

  i = hs[:i]
  hs[:i] += 1
  if arr[i] == -2
    return
  elsif arr[i] == -1
    if i + 1 < r
      node.right = Node.new(arr[i + 1])
      hs[:i] += 1
      dhelper(node.right, hs, r, arr)
    #   return
    # else
    #   return
    end
    return
  end
  node.left = Node.new(arr[i])
  dhelper(node.left, hs, r, arr)
  if hs[:i] + 1 < r
    i = hs[:i]
    hs[:i] += 1
    if arr[i] == -1
      return
    end
    node.right = Node.new(arr[i])
    dhelper(node.right, hs, r, arr)
  end
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


Node = Struct.new(:key, :left, :right)

def mirror(node)
  return if node == nil

  left = node.left
  right = node.right
  node.left = mirror(right)
  node.right = mirror(left)
  node
end

def print_preorder(node)
  return if node == nil
  print "#{node.key} "
  print_preorder(node.left)
  print_preorder(node.right)
end

root = Node.new(4)
root.left = Node.new(2)
root.left.left = Node.new(1)
root.left.right = Node.new(3)
root.right = Node.new(5)


puts "Preorder:"
puts print_preorder(root)  # 4  2  1  3  5

mirror(root)


puts "Preorder(mirrored):"
puts print_preorder(root) # 4  5  2  3  1


# iterative method
def mirror_iteratively(root)
    que = Queue.new
    que.enq(root)
    while not que.empty?
        node = que.deq
        node.left, node.right = node.right, node.left
        que.enq(node.left) if node.left
        que.enq(node.right) if node.right
    end
    root
end

Node = Struct.new(:key, :count, :left, :right)

def get_kth_from_bst(node, k)
  if node == nil
    return 'na'
  end

  left_count = node.count

  curr_k = left_count + 1

  if curr_k == k
    return node.key
  elsif curr_k > k
    get_kth_from_bst(node.left, k)
  else
    get_kth_from_bst(node.right, k - curr_k)
  end
end

root = Node.new(20, 5)
root.left = Node.new(8, 1)
root.left.left = Node.new(4, 0)
root.left.right = Node.new(12, 1)
root.left.right.left = Node.new(10, 0)
root.left.right.right = Node.new(14, 0)
root.right = Node.new(22, 0)

for k in [3,5,6,7,8]
  puts "When k: #{k}\n#{get_kth_from_bst(root, k)}"
end

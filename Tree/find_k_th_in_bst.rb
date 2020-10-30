Node = Struct.new(:key, :lcount, :left, :right)

def get_kth_from_bst(node, k)
  if node == nil
    return -1
  end

  curr_count = node.lcount + 1

  if curr_count == k
    node.key
  elsif curr_count > k
    get_kth_from_bst(node.left, k)
  else
    get_kth_from_bst(node.right, k - curr_count)
  end
end

root = Node.new(20, 5)
root.left = Node.new(8, 1)
root.left.left = Node.new(4, 0)
root.left.right = Node.new(12, 1)
root.left.right.left = Node.new(10, 0)
root.left.right.right = Node.new(14, 0)
root.right = Node.new(22, 0)
=begin

         20
      /.     \
     8        22
   /   \
  4     12
       /  \
      10   14
=end

for k in [3,5,6,7,8]
  puts "When k: #{k}\n#{get_kth_from_bst(root, k)}"
end

# Res : 3 -> 10, 5 -> 14, 6 -> 20, 7 -> 22, 8 -> -1



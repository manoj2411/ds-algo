# Given a tree and a sum, returns true if there is a path from the root
#  down to a leaf, such that adding up all the values along the path
#  equals the given sum.

Node = Struct.new(:key, :left, :right)

def has_path_sum?(node, sum)
  if node.nil?
    false
  elsif node.left.nil? and node.right.nil?
    sum == node.key
  else
    has_path_sum?(node.left, sum - node.key) ||
    has_path_sum?(node.right, sum - node.key)
  end
end

root = Node.new(5)
root.left  = Node.new(4)
root.right = Node.new(8)
root.left.left = Node.new(11)
root.left.left.left = Node.new(7)
root.left.left.right = Node.new(2)
root.right.left = Node.new(13)
root.right.right = Node.new(4)
root.right.right.right = Node.new(1)


for sum in [27,22,26,18]
  puts " Has path sum for #{sum} : #{has_path_sum?(root, sum)}" # true
end

for sum in [5,7,9,20,17]
  puts " Has path sum for #{sum} : #{has_path_sum?(root, sum)}" # false
end

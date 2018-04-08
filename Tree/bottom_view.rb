Node = Struct.new(:key, :left, :right)

def print_bottom_view(root)

  que = [[root, 0]]
  dict = {}
  min = max = 0

  while !que.empty?
    # simulating dequeue
    node, node_distance = que.delete_at(0)
    dict[node_distance] = node.key
    if node.left
      que << [node.left, node_distance - 1]
    end
    if node.right
      que << [node.right, node_distance + 1]
    end
    if node_distance > max
      max = node_distance
    elsif node_distance < min
      min = node_distance
    end
  end

  for i in min..max
    print "#{dict[i]} "
  end
  puts
end


root = Node.new 20
root.left = Node.new 8
root.left.left = Node.new 5
root.left.right = Node.new 3
root.left.right.left = Node.new 10
root.left.right.right = Node.new 14
root.right = Node.new 22
root.right.left = Node.new 4
root.right.right = Node.new 25
print_bottom_view(root)

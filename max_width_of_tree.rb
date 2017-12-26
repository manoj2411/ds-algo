Node = Struct.new(:key, :left, :right)

def print_max_width(node)
  queue = []
  queue.push node
  level_count = 1
  level = 0
  max_level = 0

  while !queue.empty?
    # new_count = 0
    q_len = queue.length
    puts "Level #{level}, count: #{q_len}"
    q_len.times do |i|
      node = queue.delete_at(0)
      if node.left
        queue.push(node.left)
        # new_count += 1
      end
      if node.right
        queue.push(node.right)
        # new_count += 1
      end
    end
    level += 1
    if level_count < queue.length
      level_count = queue.length
      max_level = level
    end
  end # END of while
  puts "Max Level #{max_level}, max_count: #{level_count}"

end

# root = Node.new(1)
# root.left = Node.new(2)
# root.right = Node.new(3)
# root.left.right = Node.new(5)
# root.left.left = Node.new(4)
# root.right.right = Node.new(8)
# root.right.right.left = Node.new(6)
# root.right.right.right = Node.new(7)

root = Node.new(4)
root.left = Node.new(5)
root.right = Node.new(2)
root.left.right = Node.new(10)
root.right.right = Node.new(1)
root.right.left = Node.new(3)
root.right.left.left = Node.new(6)
root.right.left.right = Node.new(7)


print_max_width(root)


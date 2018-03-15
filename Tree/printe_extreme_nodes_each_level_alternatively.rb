Node = Struct.new(:key, :left, :right)

def print_extreme_alternate_nodes(root)
  level = 0
  que = [root]

  while not que.empty?
    length = que.length
    i = 0
    while i < length
      curr = que.delete_at(0)
      if (level.odd? && i == 0) || (level.even? && i == length - 1)
        print "#{curr.key} "
      end
      que << curr.left if curr.left
      que << curr.right if curr.right
      i += 1
    end
    level += 1
  end
  puts
end


root = Node.new(1)
root.left = Node.new(7)
root.left.left = Node.new(6)
root.left.left.left = Node.new(12)
root.left.left.right = Node.new(14)
root.left.right = Node.new(3)
root.right = Node.new(10)
root.right.right = Node.new(4)
root.right.right.left = Node.new(18)

print_extreme_alternate_nodes(root)

Node = Struct.new(:key, :left, :right)

def identical?(root1, root2)
  if root1 == nil and root2 == nil
    return true
  elsif root1 == nil || root2 == nil
    return false
  end

  que = []
  que << [root1, root2]

  while not que.empty?
    node1, node2 = *que.shift
    if node1.key != node2.key
      return false
    end

    if node1.left && node2.left
      que << [node1.left, node2.left]
    elsif node1.left || node2.left
      return false
    end

    if node1.right && node2.right
      que << [node1.right, node2.right]
    elsif node1.right || node2.right
      return false
    end

  end
  return true
end


root1 = Node.new(1)
root1.left = Node.new(2)
root1.right = Node.new(3)
root1.left.left = Node.new(4)
root1.left.right = Node.new(5)
root1.left.right.left = Node.new(11)

root2 = Node.new(1)
root2.left = Node.new(2)
root2.right = Node.new(3)
root2.left.left = Node.new(4)
root2.left.right = Node.new(5)
root2.left.right.left = Node.new(11)

puts "Trees are same? #{identical?(root1, root2)}"

Node = Struct.new(:key, :left, :right)

def print_vertical_order(root)
  min = max = 0
  hsh = {}
  que = [[root, 0]]


  while !que.empty?
    node, num = que.delete_at(0)

    hsh[num] ||= []
    hsh[num] << node.key

    if num > max
      max = num
    elsif num < min
      min = num
    end

    if node.left
      que << [node.left, num - 1]
    end
    if node.right
      que << [node.right, num + 1]
    end
  end

  min.upto(max) do |key|
    if hsh[key]
      hsh[key].each {|e| print "#{e} " }
      puts
    end
  end
end

root = Node.new(1)
root.left = Node.new(2)
root.left.left = Node.new(4)
root.left.right = Node.new(5)
root.right = Node.new(3)
root.right.left = Node.new(6)
root.right.left.right = Node.new(8)
root.right.right = Node.new(7)
root.right.right.right = Node.new(9)

puts "Print Vertical order"
print_vertical_order(root)

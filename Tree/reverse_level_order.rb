Node = Struct.new(:key, :right, :left)

def print_reverse_level_order(root)
    que = [root]
    stack = []
    while !que.empty?
        len = que.length
        len.times do
            node = que.delete_at(0)
            que.push(node.right) if node.right
            que.push(node.left) if node.left
            stack.push(node.key)
        end
    end

    while !stack.empty?
        print "#{stack.pop} "
    end
    puts
end


root = Node.new(1)
root.left = Node.new(2)
root.left.left = Node.new(4)
root.left.left.left = Node.new(7)
root.left.right = Node.new(5)
root.left.right.right = Node.new(8)
root.right = Node.new(3)
root.right.right = Node.new(6)

def _p(node)
    return if node == nil
    print "#{node.key} "
    _p(node.left)
    _p(node.right)
end

puts "Tree: "
_p(root)
puts
puts "Reverse Level Order: "
print_reverse_level_order(root)

Node = Struct.new(:key, :left, :right)

def print_level_order_spiral(head)
    stack_odd = []
    stack_even = [head]
    level = 0

    while (not stack_even.empty?) || (not stack_odd.empty?)
        if level.even?
            while !stack_even.empty?
                node = stack_even.pop
                print "#{node.key} "
                stack_odd.push(node.right) if node.right
                stack_odd.push(node.left) if node.left
            end
        else
            while not stack_odd.empty?
                node = stack_odd.pop
                print "#{node.key} "
                stack_even.push(node.left) if node.left
                stack_even.push(node.right) if node.right
            end
        end
        level += 1
    end
end

head = Node.new(1)
head.left = Node.new(2)
head.left.left = Node.new(4)
head.left.left.left = Node.new(7)
head.left.right = Node.new(5)
head.left.right.right = Node.new(8)
head.right = Node.new(3)
head.right.left = Node.new(10)
head.right.right = Node.new(6)
head.right.right.left = Node.new(70)
head.right.right.right = Node.new(80)

def print_inorder(node)
    return if node == nil
    print_inorder(node.left)
    print "#{node.key} "
    print_inorder(node.right)
end

puts "Inorder: "
print_inorder(head)
puts

puts "Spiral Level: "
print_level_order_spiral(head)
# print_inorder(head)
puts

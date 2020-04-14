Node = Struct.new(:val, :left, :right)

def is_symmetric?(root)
    return true if root.nil?
    helper(root.left, root.right)
end

def helper(node1, node2)
    if node1.nil? and node2.nil?
        true
    elsif node1.nil? or node2.nil?
        false
    else
        node1.val == node2.val &&
        helper(node1.left, node2.right) &&
        helper(node1.right, node2.left)
    end
end


head = Node.new(1)
head.left = Node.new(2)
head.right = Node.new(2)
head.left.left = Node.new(3)
head.right.left = Node.new(3)
# puts is_symmetric?(head) # false

head = Node.new(1)
head.left = Node.new(2)
head.right = Node.new(2)
head.left.left = Node.new(3)
head.left.right = Node.new(4)
head.right.left = Node.new(4)
head.right.right = Node.new(3)
puts is_symmetric?(head) # true

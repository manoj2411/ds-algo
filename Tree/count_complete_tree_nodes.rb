TreeNode = Struct.new(:val, :left, :right)

# @param {TreeNode} root
# @return {Integer}
def count_nodes(root)
    if root.nil?
        0
    else
        left_height = 1
        left = root.left
        while left
            left_height += 1
            left = left.left
        end

        right_height = 1
        right = root.right
        while right
            right_height += 1
            right = right.right
        end

        # puts "r: #{root.val} left_height: #{left_height}, right_height: #{right_height}"
        if left_height == right_height
            (2 ** right_height) - 1
        else
            1 + count_nodes(root.left) + count_nodes(root.right)
        end
    end
end

root = TreeNode.new(1)
root.left = TreeNode.new(2)
root.right = TreeNode.new(3)
root.left.left = TreeNode.new(4)
root.left.right = TreeNode.new(5)
root.right.left = TreeNode.new(6)
puts count_nodes(root) # 6

root.right.right = TreeNode.new(24)
puts count_nodes(root) # 7

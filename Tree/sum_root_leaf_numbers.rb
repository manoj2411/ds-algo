TreeNode = Struct.new(:val, :left, :right)

def sum_numbers(root)
    res = [0]
    helper(root, 0, res) if root
    res[0]
end

def helper(root, curr, res)
    if root.left == nil and root.right == nil
        res[0] += (curr * 10) + root.val
    else
        new_curr = (curr * 10) + root.val
        helper(root.left, new_curr, res) if root.left
        helper(root.right, new_curr, res) if root.right
    end
end

# Input: [1,2,3]
#     1
#    / \
#   2   3
# Output: 25
# Explanation:
# The root-to-leaf path 1->2 represents the number 12.
# The root-to-leaf path 1->3 represents the number 13.
# Therefore, sum = 12 + 13 = 25.

root = TreeNode.new(1, TreeNode.new(2), TreeNode.new(3))
puts sum_numbers(root) # 25

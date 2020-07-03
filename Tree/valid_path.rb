## Check If a String Is a Valid Sequence from Root to Leaves Path in a Binary Tree
#
# Given a binary tree where each path going from the root to any leaf form a valid sequence, check if a given string is a valid sequence in such binary tree.
# We get the given string from the concatenation of an array of integers arr and the concatenation of all values of the nodes along a path results in a sequence in the given binary tree.


# Definition for a binary tree node.
class TreeNode
    attr_accessor :val, :left, :right
    def initialize(val = 0, left = nil, right = nil)
        @val = val
        @left = left
        @right = right
    end
end

# @param {TreeNode} root
# @param {Integer[]} arr
# @return {Boolean}
def is_valid_sequence(root, arr)
    len = arr.length
    que = Queue.new
    i = 0
    que.enq(root)

    while (not que.empty?) && i < len
        que.length.times do
            node = que.deq
            if node.val == arr[i]
                return true if i == len - 1 && node.left.nil? && node.right.nil?
                que.enq(node.left) if node.left
                que.enq(node.right) if node.right
            end
        end
        i += 1
    end
    false
end


root = TreeNode.new(0)
root.left = TreeNode.new(1)
root.left.left = TreeNode.new(0)
root.left.left.right = TreeNode.new(1)
root.left.right = TreeNode.new(1)
root.left.right.left = TreeNode.new(0)
root.left.right.right = TreeNode.new(0)
root.right = TreeNode.new(0)
root.right.left = TreeNode.new(0)


puts is_valid_sequence(root, [0,1,0,1]) # true
puts is_valid_sequence(root, [0,0,1])   # false
puts is_valid_sequence(root, [0,1,1])   # false



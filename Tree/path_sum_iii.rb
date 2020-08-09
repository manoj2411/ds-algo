# https://leetcode.com/problems/path-sum-iii/

Node = Struct.new(:val, :left, :right)

def path_sum(root, sum)
    helper(root, {}, 0, sum)
end

# 2 cases:
#   1. check is running_sum is equal to given_sum
#   2. remove given_sum from running_sum and see if the diff present in hash

def helper(node, pre_sums, running_sum, sum)
    return 0 if node.nil?

    running_sum += node.val

    res = 0
    res += 1 if running_sum  == sum

    res += pre_sums[running_sum - sum] if pre_sums[running_sum - sum]
    pre_sums[running_sum] ||= 0
    pre_sums[running_sum] += 1

    helper(node.left, pre_sums.clone, running_sum, sum) +
    helper(node.right, pre_sums.clone, running_sum, sum) +
    res
end

# # # #  Example 1:
root = Node.new(10)
root.left = Node.new(5)
root.left.left = Node.new(3)
root.left.left.left = Node.new(3)
root.left.left.right = Node.new(-2)
root.left.right = Node.new(2)
root.left.right.right = Node.new(1)
root.right = Node.new(-3)
root.right.right = Node.new(11)

puts path_sum(root, 8) # 3
puts path_sum(root, 7) # 2



# # # #  Example 2:
root = Node.new(1)
root.left = Node.new(0)
root.right = Node.new(1)
root.left.left = Node.new(1)
root.left.left.left = Node.new(0)
root.left.left.right = Node.new(1)
root.left.right = Node.new(2)
root.left.right.left = Node.new(-1)
root.left.right.right = Node.new(0)
root.right.left = Node.new(0)
root.right.left.left = Node.new(-1)
root.right.left.right = Node.new(0)
root.right.right = Node.new(-1)
root.right.right.left = Node.new(1)
root.right.right.right = Node.new(0)

puts path_sum(root, 2) # 13


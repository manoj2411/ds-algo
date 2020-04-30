TreeNode = Struct.new(:val, :left, :right)
# @param {TreeNode} root
# @param {Integer} x
# @param {Integer} y
# @return {Boolean}
def is_cousins(root, x, y)
  arr = [root]
  while not arr.empty?
    map = {}
    arr.each do |node|
      left_val = right_val = nil
      if node.left
        left_val = node.left.val
        map[left_val] = node.left
      end

      if node.right
        right_val = node.right.val
        map[right_val] = node.right
      end

      if (x == left_val || x == right_val) && (y == left_val || y == right_val)
        return false
      end
    end

    if map[x] && map[y]
      return true
    elsif map[x] || map[y]
      return false
    end

    arr = map.values
  end
  false
end


root = TreeNode.new(1)
root.left = TreeNode.new(2)
root.left.left = TreeNode.new(4)
root.right = TreeNode.new(3)
puts is_cousins(root, 4, 3) # false

root = TreeNode.new(1)
root.left = TreeNode.new(2)
root.left.right = TreeNode.new(4)
root.right = TreeNode.new(3)
root.right.right = TreeNode.new(5)
puts is_cousins(root, 5, 4) # true

root = TreeNode.new(1)
root.left = TreeNode.new(2)
root.left.right = TreeNode.new(4)
root.right = TreeNode.new(3)
puts is_cousins(root, 2, 3) # false

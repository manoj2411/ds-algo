Node = Struct.new(:key, :left, :right)

class BinaryTree

  attr_accessor :root

  def find_least_common_ancestor(key1, key2)
    @lru_found = @found_key1 = @found_key2 = nil
    dist = find_distance_util(root, key1, key2)
    if @found_key1 && @found_key2
      puts dist
    elsif @found_key1
      puts dist + find(@found_key1, key2)
    elsif @found_key2
      puts dist + find(@found_key2, key1)
    else
      puts 'Not found'
    end
  end

  private

    def find(node, key)
      return nil if node == nil
      if node.key == key
        return 0
      elsif find(node.left, key) || find(node.right, key)
        return find(node.left, key) || find(node.right, key) + 1
      else
        return
      end
    end

    def find_distance_util(node, key1, key2)
      return nil if node == nil

      if node.key == key1
        @found_key1 = node
        return 0
      elsif node.key == key2
        @found_key2 = node
        return 0
      end

      left_len = find_distance_util(node.left, key1, key2)
      right_len = find_distance_util(node.right, key1, key2)

      if left_len && right_len
        @lru_found = true
        return left_len + right_len + 2
      elsif left_len
        return @lru_found ? left_len : left_len + 1
      elsif right_len
        return @lru_found ? right_len : right_len + 1
      else
        return nil
      end
    end
end

root = Node.new(1)
root.left = Node.new(2)
root.right = Node.new(3)
root.left.left = Node.new(4)
root.left.right = Node.new(5)
root.right.left = Node.new(6)
root.right.left.right = Node.new(8)
root.right.left.left = Node.new(9)
root.right.right = Node.new(7)
btree = BinaryTree.new
btree.root = root
btree.find_least_common_ancestor(4,5)
btree.find_least_common_ancestor(4,6)
btree.find_least_common_ancestor(3,4)
btree.find_least_common_ancestor(2,4)
btree.find_least_common_ancestor(8,5)
btree.find_least_common_ancestor(8,9)

# Alternate aproach can be, find lca, then find level of both keys and return their sum

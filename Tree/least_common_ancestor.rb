Node = Struct.new(:key, :left, :right)

class BinaryTree

  attr_accessor :root

  def find_least_common_ancestor(key1, key2)
    @found_key1 = @found_key2 = false
    node = find_common_ancestor_util(root, key1, key2)
    if @found_key1 && @found_key2
      puts "Least common ancestor: #{node.key}"
    elsif (@found_key1 && find(node, key2)) || (@found_key2 && find(node, key1))
      puts "Least common ancestor: #{node.key}"
    else
      puts 'Not found'
    end
  end

  private

    def find(node, key)
      return nil if node == nil
      return node.key == key || find(node.left, key) || find(node.right, key)
    end

    def find_common_ancestor_util(node, key1, key2)
      return nil if node == nil

      if node.key == key1
        @found_key1 = true
        return node
      elsif node.key == key2
        @found_key2 = true
        return node
      end

      left_key = find_common_ancestor_util(node.left, key1, key2)
      right_key = find_common_ancestor_util(node.right, key1, key2)

      if left_key && right_key
        return node
      end
      return left_key || right_key
    end
end

root = Node.new(1)
root.left = Node.new(2)
root.right = Node.new(3)
root.left.left = Node.new(4)
root.left.right = Node.new(5)
root.right.left = Node.new(6)
root.right.left.right = Node.new(8)
root.right.right = Node.new(7)
btree = BinaryTree.new
btree.root = root
btree.find_least_common_ancestor(8,5)

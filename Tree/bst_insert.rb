# require 'byebug'
Node = Struct.new(:key, :left, :right)

class Bst

  attr_accessor :root

  def insert(key)
    node = Node.new(key)
    if root == nil
      self.root = node
      return
    end
    add_to_subtree(root, node)
  end

  private
    def add_to_subtree(node, new_node)
      if node.key > new_node.key
        # add to left
        if node.left == nil
          node.left = new_node
          return
        end
        add_to_subtree(node.left, new_node)
      elsif node.key < new_node.key
        # add to right
        if node.right == nil
          node.right = new_node
          return
        end
        add_to_subtree(node.right, new_node)
      else
        raise 'Duplicate keys are not allowed!'
      end
    end
end

bst = Bst.new
bst.insert(2)
bst.insert(10)
bst.insert(1)
bst.insert(5)

# debugger
# true

# require 'byebug'
Node = Struct.new(:key, :left, :right)

class Bst

  attr_accessor :root

  def insert(key)
    node = Node.new(key)
    self.root = insert_util(root, node)
  end

  private
    def insert_util(node, new_node)
      return new_node if node.nil?

      if node.key > new_node.key
        # add to left
        node.left = insert_util(node.left, new_node)
      elsif node.key < new_node.key
        # add to right
        node.right = insert_util(node.right, new_node)
      else
        raise 'Duplicate keys are not allowed!'
      end

      node # returns current node
    end
end

bst = Bst.new
bst.insert(2)
bst.insert(10)
bst.insert(1)
bst.insert(5)

# debugger
# true

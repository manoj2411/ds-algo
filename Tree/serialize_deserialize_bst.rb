Node = Struct.new(:key, :left, :right)

class Bst
  attr_accessor :root

  def add_node(x)
    node = Node.new(x)
    if root.nil?
      self.root = node
      return true
    end
    add_helper(root, node)
  end

  def pp(node = @root)
    return if node.nil?
    print node.key
    print ' '
    pp node.left
    pp node.right
  end

  def self.serialize(root)
    arr = []
    serialize_helper(root, arr)
    return arr
  end

  def self.deserialize(arr)
    bst = self.new
    arr.each do |key|
      bst.add_node(key)
    end
    return bst
  end

  private
    def add_helper(root, node)
      if root.key > node.key
        # add it to left subtree
        if root.left.nil?
          root.left = node
          return
        end
        add_helper(root.left, node)
      else
        # add it to right subtree
        if root.right.nil?
          root.right = node
          return
        end
        add_helper(root.right, node)
      end
    end

    # insert nodes in preorder
    def self.serialize_helper(node, arr)
      return if node.nil?

      arr << node.key
      serialize_helper(node.left, arr)
      serialize_helper(node.right, arr)
    end
end


root = Node.new 20
root.right = Node.new 22
root.left = Node.new 8
root.left.left = Node.new 4
root.left.right = Node.new 12
root.left.right.left = Node.new 10
root.left.right.right = Node.new 14

serialized = Bst.serialize(root)
puts "Serialised:"
p serialized.to_s

bst = Bst.deserialize(serialized)
puts "Bst: "
bst.pp
puts

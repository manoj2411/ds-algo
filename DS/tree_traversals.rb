Node = Struct.new(:item, :left, :right)

root = Node.new('A')
left = Node.new('B')
right = Node.new('C')
root.left = left
root.right = right
node = Node.new('D')
left.right = node
right.left = Node.new('E')
right.right = Node.new('F')
right.left.left = Node.new('G')
right.right.left = Node.new('H')
right.right.right = Node.new('I')


class Tree

  attr_accessor :root

  def initialize(root)
    @root = root
  end

  def traverse(order = 'inorder')
    case order
    when 'inorder'
      puts "Inorder: "
      inorder(root)
    when 'preorder'
      puts "Preorder: "
      preorder(root)
    when 'postorder'
      puts 'Postorder: '
      postorder(root)
    end
    puts
  end

  private
    def inorder(node)
      return if node.nil?
      inorder(node.left)
      print "#{node.item} "
      inorder(node.right)
    end

    def preorder(node)
      return if node.nil?
      print "#{node.item} "
      preorder(node.left)
      preorder(node.right)
    end

    def postorder(node)
      return if node.nil?
      postorder(node.left)
      postorder(node.right)
      print "#{node.item}   "

    end
end

tree = Tree.new(root)
tree.traverse('postorder')

Node = Struct.new(:key, :left, :right)
module BinaryTree
  module_function

  def inorder(node, prev)
    return if node == nil

    inorder(node.left, prev)
    # print "#{node.key}.prev(l) = #{store.curr.key} .. "
    node.left = prev[0]
    # print "#{store.curr.key}.next(r) = #{node.key} .. "
    prev[0].right = node
    # print "curr is #{store.curr.key}\n"
    prev[0] = node
    inorder(node.right, prev)

  end

  def to_dll(root)
    dummy = Node.new('dummy')
    store = [dummy]
    inorder(root, store)
    dummy.right.left = nil
    return dummy.right
  end

end

def print_list(root)
  while root != nil
    # puts "left: #{curr.left.key if curr.left} .. key: #{curr.key} .. right #{curr.right.key if curr.right}"
    print "#{root.key} "
    root = root.right
  end
  puts
end

root = Node.new(10)
root.left = Node.new(12)
root.right = Node.new(15)
root.left.left = Node.new(25)
root.left.right = Node.new(30)
root.right.left = Node.new(36)

head = BinaryTree.to_dll(root)

print_list(head)

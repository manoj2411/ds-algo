Node = Struct.new(:key, :left, :right)
module BinaryTree
  module_function
  Store = Struct.new(:curr)

  def inorder(node, store)
    return if node == nil

    inorder(node.left, store)
    # print "#{node.key}.prev(l) = #{store.curr.key} .. "
    node.left = store.curr
    # print "#{store.curr.key}.next(r) = #{node.key} .. "
    store.curr.right = node
    # print "curr is #{store.curr.key}\n"
    store.curr = store.curr.right
    inorder(node.right, store)

  end

  def to_dll(root)
    dummy = Node.new('dummy')
    store = Store.new(dummy)
    inorder(root, store)
    return dummy
  end

end

def print_list(root)
  curr = root.right
  while curr != nil
    puts "left: #{curr.left.key if curr.left} .. key: #{curr.key} .. right #{curr.right.key if curr.right}"
    curr = curr.right
  end
end

root = Node.new(10)
root.left = Node.new(12)
root.right = Node.new(15)
root.left.left = Node.new(25)
root.left.right = Node.new(30)
root.right.left = Node.new(36)

root = BinaryTree.to_dll(root)

print_list(root)

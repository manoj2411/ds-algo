Node = Struct.new(:key, :left, :right)

def create_binary_tree(inorder, postorder)
    length = inorder.length
    refs = Struct.new(:i).new(length - 1)
    create_helper(inorder, postorder, 0, length - 1, refs)
end

def create_helper(inorder, postorder, l, h, refs)
    if l > h && l < 0
        return
    end
    inorder_indx = inorder.index(postorder[refs.i])

    if not (l..h).cover?(inorder_indx)
        return
    end
    node = Node.new(postorder[refs.i])
    refs.i -= 1
    node.right = create_helper(inorder, postorder, inorder_indx + 1, h, refs)
    node.left = create_helper(inorder, postorder, l, inorder_indx - 1, refs)
    return node
end

def _p(node)
    return if node == nil

    print "#{node.key} "
    _p(node.left)
    _p(node.right)
end

head = create_binary_tree([4, 8, 2, 5, 1, 6, 3, 7], [8, 4, 5, 2, 6, 7, 3, 1])
_p(head)
puts

Node = Struct.new(:key, :left, :right)

def create_binary_tree(inorder, preorder)
    left = 0
    right = preorder.length - 1
    refs = Struct.new(:pre_i).new(0)
    return create_tree_helper(inorder, preorder, left, right, refs)
end

def create_tree_helper(inorder, preorder, left, right, refs)
    if right >= left
        key = preorder[refs.pre_i]
        in_i = inorder.index(key)
        if not (left..right).cover?(in_i)
            puts "executed not in cover"
            return nil
        end
        node = Node.new(key)
        refs.pre_i += 1
        node.left = create_tree_helper(inorder, preorder, left, in_i - 1, refs)
        node.right = create_tree_helper(inorder, preorder, in_i + 1, right, refs)
        return node
    end

    return nil
end


def p_tree(node)

    return if node == nil
    p_tree(node.left)
    print "#{node.key} "
    p_tree(node.right)

end

inorder = ['d', 'b', 'e', 'a', 'f', 'c']
preorder = ['a', 'b', 'd', 'e', 'c', 'f']

head = create_binary_tree(inorder, preorder)

p_tree(head)
puts


def print_postorder_from_given_inorder_and_preorder(inorder, preorder)
    left = 0
    right = preorder.length - 1
    refs = Struct.new(:p_i).new(0)
    p_postorder(inorder, preorder, left, right, refs)
end

def p_postorder(inorder, preorder, left, right, refs)
    if left > right
        return
    end

    root_i = inorder.index(preorder[refs.p_i])
    if not (left..right).cover?(root_i)
        return
    end

    refs.p_i += 1
    # process left
    p_postorder(inorder, preorder, left, root_i - 1, refs)
    # process right
    p_postorder(inorder, preorder, root_i + 1, right, refs)

    # print root
    print "#{inorder[root_i]} "
end


inorder = [4, 2, 5, 1, 3, 6]
preorder = [1, 2, 4, 5, 3, 6]

print_postorder_from_given_inorder_and_preorder(inorder, preorder)
puts

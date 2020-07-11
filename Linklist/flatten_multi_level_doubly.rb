# How to run?
#  1. go to leetcode : https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
#  2. paste this solution
#

Node = Struct.new(:val, :prev, :next, :child)

# @param {Node} root
# @return {Node}
def flatten(root)
    traverse(root)
    root
end

def traverse(root)
    curr = root
    prev = nil
    while curr
        _next = curr.next

        if curr.child
            last = traverse(curr.child)
            curr.next = curr.child
            curr.child.prev = curr

            last.next = _next
            _next.prev = last if _next

            curr.child = nil
            _next = last
        end

        prev = curr
        curr = _next
    end
    prev
end


# conflict resolution:
#   If two nodes have the same position, then the value of the node that is
#   reported first is the value that is smaller.
#
Node = Struct.new(:val, :left, :right)
def vertical_traversal(root)
    _hash = {}
    max = min = 0
    que = Queue.new
    que.enq([root, 0, 0])

    while not que.empty?
        node, pos, level = que.deq

        _hash[pos] ||= []
        _hash[pos] << [node.val, level]
        max = pos if pos > max
        min = pos if pos < min

        que.enq([node.left, pos - 1, level + 1]) if node.left
        que.enq([node.right, pos + 1, level + 1]) if node.right
    end

    (min..max).map do |pos|
        _hash[pos].sort_by { |e| [e[1], e[0]] }.map{|e| e[0] }
    end
end

root = Node.new(1)
root.left = Node.new(2)
root.right = Node.new(3)
root.left.left = Node.new(4)
root.left.right = Node.new(15)
root.right.left = Node.new(6)
root.right.right = Node.new(7)

puts vertical_traversal(root).to_s # [[4],[2],[1,6,15],[3],[7]]

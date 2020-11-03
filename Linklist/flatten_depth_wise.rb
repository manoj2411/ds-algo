Node = Struct.new(:key, :next, :child)

def flatten(head)
    arr = []
    flatten_util(head, arr)
end

def flatten_util(node, prev)

    return if node == nil


    prev[0] = node
    nxt = node.next

    node.next = flatten_util(node.child, prev)

    prev[0].next = flatten_util(nxt, prev)

    node
end

def _p(head)
    curr = head
    while curr != nil
        print "#{curr.key} "
        curr = curr.next
    end
    puts
end

head = Node.new(1)
head.next = Node.new(2)
head.next.child = Node.new(7)
head.next.child.child = Node.new(9)
head.next.child.child.child = Node.new(14)
head.next.child.child.child.child = Node.new(15)
head.next.child.child.child.child.next = Node.new(23)
head.next.child.child.child.child.next.child = Node.new(24)

head.next.child.next = Node.new(8)
head.next.child.next.child = Node.new(16)
head.next.child.next.child.child = Node.new(17)
head.next.child.next.child.child.next = Node.new(18)
head.next.child.next.child.child.next.next = Node.new(19)
head.next.child.next.child.child.next.next.next = Node.new(20)
head.next.child.next.child.child.next.next.next.child = Node.new(21)

head.next.child.next.next = Node.new(10)
head.next.child.next.next.child = Node.new(11)
head.next.child.next.next = Node.new(12)

head.next.next = Node.new(3)
head.next.next.next = Node.new(4)

# _p(head)
head = flatten(head)
_p(head)

Node = Struct.new(:key, :right, :down)

def flatten(head)
    curr_list = head
    new_head = nil
    while curr_list != nil
        new_head = merge(new_head, curr_list)
        right = curr_list.right
        curr_list.right = nil
        curr_list = right
    end
    return new_head
end

def merge(l1, l2)
    return nil if l1 == nil && l2 == nil
    return l1 if l2 == nil
    return l2 if l1 == nil

    if l1.key < l2.key
        l1.down = merge(l1.down, l2)
        return l1
    else
        l2.down = merge(l2.down, l1)
        return l2
    end
end

head = Node.new(5)
head.down = Node.new(7)
head.down.down = Node.new(8)
head.down.down.down = Node.new(30)

head.right = Node.new(10)
head.right.down = Node.new(20)

head.right.right = Node.new(19)
head.right.right.down = Node.new(22)
head.right.right.down.down = Node.new(50)

head.right.right.right = Node.new(28)
head.right.right.right.down = Node.new(35)
head.right.right.right.down.down = Node.new(40)
head.right.right.right.down.down.down = Node.new(45)

def p_nest(head)
    curr_l = head
    while curr_l != nil
        curr = curr_l
        while curr != nil
            print "#{curr.key} "
            curr = curr.down
        end
        puts "\n"
        curr_l = curr_l.right
    end
end

p_nest(head)
puts 'After flattening: '
head = flatten(head)
p_nest(head)

require 'pry'

Node = Struct.new(:key, :next, :child)

def flatten(head)
  que = []
  dummy = Node.new('dummy')
  curr = dummy
  que.push(head)
  while !que.empty?
    length = que.length
    length.times do
      node = que.delete_at(0)
      while node != nil
        if node.child != nil
          que.push(node.child)
        end
        curr.next = node
        curr = curr.next
        node = node.next
      end
    end
  end
  curr = dummy
  while curr != nil
    print "#{curr.key} "
    curr = curr.next
  end
  dummy
end


head = Node.new(10)
head.next = Node.new(5)
head.next.next = Node.new(12)
head.next.next.next = Node.new(7)
head.next.next.next.next = Node.new(11)

head.child = Node.new(4)
head.child.next = Node.new(20)
head.child.next.next = Node.new(13)
head.child.next.child = Node.new(2)
head.child.next.next.child = Node.new(16)
head.child.next.next.child.child = Node.new(3)

seven = head.next.next.next
seven.child = Node.new(17)
seven.child.next = Node.new(6)
seven.child.child = Node.new(9)
seven.child.child.next = Node.new(8)
seven.child.child.child = Node.new(19)
seven.child.child.child.next = Node.new(15)

flatten(head)


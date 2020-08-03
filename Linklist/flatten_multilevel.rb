require 'pry'

Node = Struct.new(:key, :next, :child) do
  def pp
    curr = self
    while curr
      print "#{curr.key} "
      curr = curr.next
    end
    puts
  end

end

def flatten(head)
  tail = curr = head

  while curr

    if curr.child
      while tail.next
        tail = tail.next
      end

      tail.next = curr.child
    end

    curr = curr.next
  end

  head
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

flatten(head).pp
# 10 > 5 > 12 > 7 > 11 > 4 > 20 > 13 > 17 > 6 > 2 > 16 > 9 > 8 > 3 > 19 > 15

require "pry"
Head = Struct.new(:key, :next, :down)
Node = Struct.new(:key, :down)

def flatten(head)
  list = []
  dummy = Node.new('dummy')
  dummy_curr = dummy
  curr_head = head
  while curr_head != nil
    list.push(curr_head)
    curr_head = curr_head.next
  end

  while !list.empty?
    list.sort_by! {|e| e.key }
    node = list.delete_at(0)
    dummy_curr.down = node
    dummy_curr = dummy_curr.down
    # dummy_curr.down = nil
    if node.down != nil
      list.push(node.down)
    end
  end

  return dummy
end

head = Head.new(5)
head.next = Head.new(10)
head.next.next = Head.new(19)
head.next.next.next = Head.new(28)

head.down = Node.new(7)
head.down.down = Node.new(8)
head.down.down.down = Node.new(30)

head.next.down = Node.new(20)

head.next.next.down = Node.new(22)
head.next.next.down.down = Node.new(50)

head.next.next.next.down = Node.new(35)
head.next.next.down.down.down = Node.new(40)
head.next.next.down.down.down.down = Node.new(45)

# puts head
sorted = flatten(head)
while sorted != nil
  print "#{sorted.key} "
  sorted = sorted.down
end

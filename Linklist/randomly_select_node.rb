Node = Struct.new(:item, :next)

def randomly_select_node(start)
  curr = start
  selected = nil
  length = 0

  while(curr != nil)
    length += 1
    # using 0 becase rand(1) will return first integer which is 0
    if rand(length) == 0
      selected = curr
    end
    curr = curr.next
  end
  return selected
end

head = Node.new(10)
head.next = Node.new(20)
head.next.next = Node.new(30)
head.next.next.next = Node.new(40)
head.next.next.next.next = Node.new(50)

node = randomly_select_node(head)
puts "Selected node: #{node.item}"

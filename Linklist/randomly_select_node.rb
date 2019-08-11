Node = Struct.new(:item, :next)

def randomly_select_node(head)
  selected = curr = head
  i = 1

  while(curr != nil)
    selected = curr if rand(0..i) == i
    curr = curr.next
    i += 1
  end

  selected # returning result
end

head = Node.new(10)
head.next = Node.new(20)
head.next.next = Node.new(30)
head.next.next.next = Node.new(40)
head.next.next.next.next = Node.new(50)

# run algo 5 times
for i in 1..5
  puts "Selected node: #{randomly_select_node(head).item}"
end

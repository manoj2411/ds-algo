require "byebug"

Node = Struct.new(:item, :next)
# def reverse(node, start)
#   unless node.next
#     return [node, node]
#   end

#   _next, _start = reverse(node.next, start)
#   _next.next = node
#   puts "#{node.item}, #{start.item}"
#   node.next = nil if node.item == start.item
#   return node, _start
# end

def print_list(node)
  curr = node
  items = []
  while curr != nil
    items.push curr.item
    curr = curr.next
  end
  puts items.join(' -> ')
end

def reverse(node)

  if node.next == nil || node == nil
    return node # returning head
  end

  head = reverse(node.next)

  node.next.next = node
  node.next = nil
  return head

end




n1 = Node.new(1, nil)
n2 = Node.new(2, nil)
n3 = Node.new(3, nil)
n4 = Node.new(4, nil)
n5 = Node.new(5, nil)

n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5

puts "Old list: "
print_list n1
head = reverse(n1)
puts "New list: "
print_list head
# _end, start = reverse(n1, n1)
# debugger
# true

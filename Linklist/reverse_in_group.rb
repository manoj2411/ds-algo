# Algorithm
#
# 1. take 3 vars i.e. curr, prev, next
# 2. On every recursion call, reverse the group iteratively and return prev (new head)
Node = Struct.new(:key, :next)

def pp(node)
  curr = node
  res = []
  while curr != nil
    res << curr.key
    curr = curr.next
  end
  puts res.join(" -> ")
end

def reverse_in_group(head, k)
  prev = nil
  curr = head

  i = 0

  while curr && i < k
    _next = curr.next
    curr.next = prev
    prev = curr
    curr = _next
    i += 1
  end


  head.next = reverse_in_group(curr, k) if curr


  prev

end


[1,2,3,4].each do |k|

  head = Node.new(1)
  head.next = Node.new 2
  head.next.next = Node.new 3
  head.next.next.next = Node.new 4
  head.next.next.next.next = Node.new 5
  head.next.next.next.next.next = Node.new 6
  head.next.next.next.next.next.next = Node.new 7
  head.next.next.next.next.next.next.next = Node.new 8


  puts "Original: "
  pp head
  head = reverse_in_group head, k
  puts "Reversed in group of #{k}"
  pp head
  puts
end

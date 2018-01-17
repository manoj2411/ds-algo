Head = Struct.new(:key, :next, :down)
Node = Struct.new(:key, :down)

def _print(head)
  list_head = head
  puts
  while list_head != nil
    print " #{list_head.key} "
    list_head = list_head.down
  end
end

def flatten(head)
  if head == nil || head.next == nil
    return head
  end
  nxt_head = flatten(head.next)
  return merge(head, nxt_head)
end

def merge(list1, list2)

  return list2 if list1 == nil
  return list1 if list2 == nil

  if list1.key <= list2.key
    list1.down = merge(list1.down, list2)
    return list1
  else
    list2.down = merge(list1, list2.down)
    return list2
  end

end

head = Head.new(5)
head.down = Node.new(7)
head.down.down = Node.new(8)
head.down.down.down = Node.new(30)

head.next = Head.new(10)
head.next.down = Node.new(20)

head.next.next = Head.new(19)
head.next.next.down = Node.new(22)
head.next.next.down.down = Node.new(50)

head.next.next.next = Head.new(28)
head.next.next.next.down = Node.new(35)
head.next.next.next.down.down = Node.new(40)
head.next.next.next.down.down.down = Node.new(45)

list_head = flatten(head)
puts "\nFinal: "
_print list_head
# _print(head)
# _print(head.next)
# _print(head.next.next)
# _print(head.next.next.next)

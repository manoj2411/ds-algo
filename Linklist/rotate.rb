require "byebug"
Node = Struct.new(:item, :next)

def rotate(start, input)
  curr = start
  k = 1
  tmp = nil
  while curr.next != nil
    if k == input
      tmp = curr
    end
    k += 1
    curr = curr.next
  end
  curr.next = start
  start = tmp.next
  tmp.next = nil
  return start
end

n1 = Node.new(10, nil)
n2 = Node.new(20, nil)
n3 = Node.new(30, nil)
n4 = Node.new(40, nil)
n5 = Node.new(50, nil)
n6 = Node.new(60, nil)

n1.next = n2
n2.next = n3
n3.next = n4
n4.next = n5
n5.next = n6

start = rotate(n1, 4)

debugger
true

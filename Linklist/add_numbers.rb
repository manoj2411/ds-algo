Node = Struct.new(:key, :next)

def add(node1, node2)
  return node2 if node1 == nil
  return node1 if node2 == nil

  result = Node.new('dummy')
  curr = result
  carry = 0

  while node1 && node2
    sum = node1.key + node2.key + carry
    curr.next = Node.new sum % 10
    carry = sum / 10
    curr = curr.next
    node1 = node1.next
    node2 = node2.next
  end

  while node1
    sum = node1.key + carry
    curr.next = Node.new(sum % 10)
    carry = sum / 10
    curr = curr.next
    node1 = node1.next
  end

  while node2
    sum = node2.key + carry
    curr.next = Node.new( sum % 10)
    carry = sum / 10
    curr = curr.next
    node2 = node2.next
  end

  curr.next = Node.new carry if carry > 0

  result.next
end

def _p(node)
  while node != nil
    print "#{node.key} "
    node = node.next
  end
  puts
end


num1 = Node.new 5
num1.next = Node.new 4
num1.next.next = Node.new 3

num2 = Node.new 5
num2.next = Node.new 4

num1 = Node.new 5
num1.next = Node.new 6
num1.next.next = Node.new 3
num2 = Node.new 8
num2.next = Node.new 4
num2.next.next = Node.new 2

sum = add(num1, num2)
puts "List1: "
_p(num1)
puts "List2: "
_p(num2)
puts "Sum: "
_p(sum)

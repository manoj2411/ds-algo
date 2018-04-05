Node = Struct.new(:key, :next)


def merge_k_sorted(arr)
  high = arr.length - 1

  while high != 0
    low = 0
    while low < high
      arr[low] = merge(arr[low], arr[high])
      low += 1
      high -= 1
    end
  end

  return arr[0]
end

def merge(list1, list2)
  if list1 == nil
    return list2
  elsif list2 == nil
    return list1
  elsif list1.key < list2.key
    list1.next = merge(list1.next, list2)
    return list1
  else
    list2.next = merge(list1, list2.next)
    return list2
  end
end

arr = []

head = Node.new(1)
head.next = Node.new(2)
head.next.next = Node.new(3)
arr << head

head = Node.new 4
head.next = Node.new 5
arr << head

head = Node.new 5
head.next = Node.new 6
arr << head

head = Node.new 7
head.next = Node.new 8
arr << head

head = merge_k_sorted(arr)

puts "List: "
node = head
while node != nil
  print "#{node.key} -> "
  node = node.next
end
puts 'NULL'

Node = Struct.new(:key, :next)

def len(node)
  count = 0
  while node != nil
    count += 1
    node = node.next
  end
  return count
end

def add_same_length_lists(n1, n2, store)
  raise "Sherlock required to solve this case!" if (n1 == nil && n2) || (n2 == nil && n1)

  if n1.next == nil && n2.next == nil
    num = n1.key + n2.key
    store[:carry] = num / 10
    return Node.new(num % 10)
  end

  res = add_same_length_lists(n1.next, n2.next, store)
  num = n1.key + n2.key + store[:carry]
  store[:carry] = num / 10
  node = Node.new(num % 10)
  node.next = res
  return node
end

def adjust_bigger_list(l1, diff, res, store)
  if diff == 0
    num = l1.key + store[:carry]

    store[:carry] = num / 10
    node = Node.new(num % 10)
    node.next = res
    return node
  end

  new_res = adjust_bigger_list(l1.next, diff - 1, res, store)
  num = l1.key + store[:carry]
  store[:carry] = num / 10
  node = Node.new(num % 10)
  node.next = new_res
  return node
end

def sum_ll(l1, l2)
  # get length
  # if not equal then get set higher and lower
  # adjust higher to be same length as lower
  # recursively add lists with same length
  # if diff was 0 then adjust carry and return
  # else recursively adjust carry with 1 list and then return

  len_l1 = len(l1)
  len_l2 = len(l2)
  diff = nil
  if len_l1 == len_l2
    diff = 0
  else
    if len_l1 < len_l2
      len_l2, len_l1 = len_l1, len_l2
      l1, l2 = l2, l1
    end
    diff = len_l1 - len_l2
  end
  # Now l1 will be >= l2 length wise
  c1 = l1
  diff.times { c1 = c1.next }
  store = {carry: 0}
  # binding.pry
  res = add_same_length_lists(c1, l2, store)

  if diff > 0
    res = adjust_bigger_list(l1, diff - 1, res, store)
  end

  if store[:carry] > 0
    node = Node.new(store[:carry])
    node.next = res
    res = node
  end

  return res
end


def pp(node)
  while node != nil
    print node.key
    print ' '
    node = node.next
  end
  puts
end


l1 = Node.new(9)
# l1 = Node.new(1)
l1.next = Node.new(4)
# l2 = Node.new(1)
# l2.next = Node.new(6)

l2 = Node.new(9)
l2.next = Node.new(8)
l2.next.next = Node.new(9)

res = sum_ll(l1, l2)

puts "Num1: "
pp l1
puts "Num2: "
pp l2
puts "Res: "
pp res


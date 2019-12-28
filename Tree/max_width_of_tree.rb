Node = Struct.new(:key, :left, :right)

def print_max_width(node)
  return 0 if node.nil?

  queue = Queue.new
  queue.enq(node)
  max_width = 1
  max_level = 0
  level = 0

  while !queue.empty?
    # new_count = 0
    que_len = queue.length
    # puts "Level #{level}, count: #{que_len}"
    que_len.times do |_|
      node = queue.deq
      queue.enq(node.left) if node.left
      queue.enq(node.right) if node.right
    end

    level += 1
    if max_width < queue.length
      max_width = queue.length
      max_level = level
    end
  end # END of while

  puts "Max Level #{max_level}, max_count: #{max_width}"
end

def max_width_preorder(node, arr, leveql)
  return if node == nil

  arr[level] ||= 0
  arr[level] += 1
  max_width_preorder(node.left, arr, level + 1)
  max_width_preorder(node.right, arr, level + 1)
end

# root = Node.new(1)
# root.left = Node.new(2)
# root.right = Node.new(3)
# root.left.right = Node.new(5)
# root.left.left = Node.new(4)
# root.right.right = Node.new(8)
# root.right.right.left = Node.new(6)
# root.right.right.right = Node.new(7)

root = Node.new(4)
root.left = Node.new(5)
root.right = Node.new(2)
root.left.right = Node.new(10)
root.right.right = Node.new(1)
root.right.left = Node.new(3)
root.right.left.left = Node.new(6)
root.right.left.right = Node.new(7)


print_max_width(root)
# arr = []
# max_width_preorder(root, arr, 0)

# arr.each_with_index do |ele, indx|
#   puts "Level: #{indx} Width: #{ele}"
# end


# # # # # # # # New refactored implementation

def find_max_width(head)
  que = Queue.new
  que.enq head
  level = 0

  while not que.empty?
    length = que.length
    level += 1
    puts "Level: #{level} width: #{length}"
    length.times do
      node = que.deq
      que.enq(node.left) if node.left
      que.enq(node.right) if node.right
    end
  end

end

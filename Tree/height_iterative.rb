Node = Struct.new(:key, :left, :right)

class Array
  def enqueue(element)
    self.push(element)
  end

  def dequeue
    self.delete_at(0)
  end
end

def height(node)
  queue = []
  queue.enqueue(node)
  depth = 0
  while !queue.empty?
    q_length = queue.length
    depth += 1
    q_length.times do
      curr_node = queue.dequeue
      queue.enqueue(curr_node.left) if curr_node.left
      queue.enqueue(curr_node.right) if curr_node.right
    end
  end
  return depth
end

root = Node.new(1)
root.left = Node.new(2)
root.right = Node.new(3)
root.left.left = Node.new(4)
root.left.right = Node.new(5)
root.left.right.left = Node.new(15)
root.left.right.left.left = Node.new(156)

puts " Height of Binary tree is: #{height(root)}"

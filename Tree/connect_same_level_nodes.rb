Node = Struct.new(:key, :left, :right, :next)

def set_next_links(root)
  que = [root]
  while !que.empty?
    count = que.length
    prev = nil
    count.times do
      node = que.delete_at(0)
      if prev
        prev.next = node
      end
      prev = node
      que << node.left if node.left
      que << node.right if node.right
    end
  end
end

def print_levels(root)
  curr = root
  while curr != nil
    _next_level = nil
    while curr != nil
      print("#{curr.key} ")
      _next_level ||= curr.left || curr.right
      curr = curr.next
    end
    curr = _next_level
  end
end

root = Node.new(10)
root.left = Node.new(20)
root.left.left = Node.new(40)
root.left.right = Node.new(60)
root.right = Node.new(30)

set_next_links(root)
print_levels(root)

Node = Struct.new(:key, :left, :right)

def same_trees?(node1, node2)
  if node1 == nil && node2 == nil
    true
  elsif node1 == nil || node2 == nil
    false
  else
    node1.key == node2.key &&
    same_trees?(node1.left, node2.left) &&
    same_trees?(node1.right, node2.right)
  end
end

def subtree?(s, t)
  if s == nil
    true
  elsif t == nil
    false
  elsif same_trees?(s, t)
    true
  else
    subtree?(s, t.left) || subtree?(s, t.right)
  end
end


t = Node.new(1)
t.left = Node.new(2)
t.right = Node.new(3)
t.right.left = Node.new(4)
t.right.right = Node.new(6)
t.right.right.right = Node.new(7)

s = Node.new(3)
s.left = Node.new(4)
s.right = Node.new(6)
s.right.right = Node.new(7)
puts "Is S is subtree of T #{subtree?(s, t)}"

t = Node.new(26)
t.left = Node.new(10)
t.right = Node.new(3)
t.right.right = Node.new(3)
t.left.left = Node.new(4)
t.left.right = Node.new(6)
t.left.left.right = Node.new(30)
t.right.right.right = Node.new(7)

s = Node.new(10)
s.left = Node.new(4)
s.left.right = Node.new(30)
s.right = Node.new(6)
# s.right.left = Node.new(6)
puts "Is S is subtree of T #{subtree?(s, t)}"

#        (S)
#          x
#        /    \
#      a       b
#     /
#    c

#        (T)
#          x
#        /    \
#      a       b
#     /         \
#    c            d

s = Node.new('x')
s.left = Node.new('a')
s.left.left = Node.new('c')
s.right = Node.new('b')

t = Node.new('x')
t.left = Node.new('a')
t.left.left = Node.new('c')
t.right = Node.new('b')
t.right.right = Node.new('d')
puts "Is S is subtree of T #{subtree?(s, t)}"
# false

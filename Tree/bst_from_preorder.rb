TreeNode = Struct.new(:val, :left, :right)
# @return {TreeNode}
def bst_from_preorder(preorder)
    head = nil
    preorder.each do |val|
    head = insert(head, val)
    end
    head
end

def insert(head, val)
  return TreeNode.new(val) if head.nil?

  if head.val > val
    head.left = insert(head.left, val)
  else
    head.right = insert(head.right, val)
  end
  head
end

def ppp(head)
  return unless head
  ppp(head.left)
  print "#{head.val} "
  ppp(head.right)
end

head = bst_from_preorder([8,5,1,7,10,12])

ppp head
puts

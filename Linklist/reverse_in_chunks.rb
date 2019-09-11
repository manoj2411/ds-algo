# NOTE: this is different solution where we only sort the group of nodes iif the group
#       has k elements.
require "pry"

Node = Struct.new(:key, :next)

def reverse_in_chunks(start, k)
  curr = start
  new_start = nil
  chunk_count = 1
  prev = nil

  while curr != nil
    s_chunk = curr

    # This loop is to check for a sepicif usecase i.e. reverse iif list has more than k nodes
    while chunk_count < k && curr != nil
      chunk_count += 1
      curr = curr.next
    end

    if chunk_count != k || curr == nil
      return new_start || start
    end


    chunk_count = 1 # resets chunk_count
    s = curr.next
    ss = s_chunk

    while s_chunk != curr
      tmp = s_chunk
      s_chunk = s_chunk.next
      tmp.next = s
      s = tmp
    end

    if new_start == nil
      new_start = curr
    end
    prev.next = curr if prev
    prev = ss
    tmp = curr
    curr = curr.next
    tmp.next = s
  end

  return new_start || start
end


head = Node.new(1)
head.next = Node.new(3)
head.next.next = Node.new(4)
head.next.next.next = Node.new(5)
head.next.next.next.next = Node.new(2)
head.next.next.next.next.next = Node.new(7)
head.next.next.next.next.next.next = Node.new(12)
head.next.next.next.next.next.next.next = Node.new(9)
head.next.next.next.next.next.next.next.next = Node.new(0)

# 1, 3, 4, 5, 2, 7, 12, 9
# 4, 3, 1, 7, 2, 5, 12, 9

def _p(node)
  curr = node
  while curr != nil
    print "#{curr.key} "
    curr = curr.next
  end
  puts
end

_p(head)

s = reverse_in_chunks(head, 3)
_p(s)

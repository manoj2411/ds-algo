# Time Complexity: O(n Log n)
# in all 3 cases (worst, average and best)
#
# Algorithmic Paradigm: Divide and Conquer
#
# Preferred for sorting a linked list.


Node = Struct.new(:item, :next)

module MergeSort
  extend self

  def sort(node)
    if node.nil? || node.next.nil?
      return node
    end

    mid = get_middle_node(node)
    next_list_head = mid.next
    mid.next = nil

    left_list = sort(node)
    right_list = sort(next_list_head)

    head = merge_sorted_lists(left_list, right_list)
    return head
  end

  def get_middle_node(node)
    slow = node
    fast = node.next
    while fast != nil
      fast = fast.next
      if fast != nil
        fast = fast.next
        slow = slow.next
      end
    end # End of while loop

    return slow
  end


  def merge_sorted_lists(list_a, list_b)
    if list_a.nil?
      return list_b
    elsif list_b.nil?
      return list_a
    end

    result = nil

    if list_a.item < list_b.item
      result = list_a
      result.next = merge_sorted_lists(list_a.next, list_b)
    else
      result = list_b
      result.next = merge_sorted_lists(list_a, list_b.next)
    end

    return result
  end

end

def print_link_list(head)
  curr = head

  while curr != nil
    print "#{curr.item} -> "
    curr = curr.next
  end
end

# arr = [12, 11, 13, 5, 6, 7]
head = Node.new(12)
head.next = Node.new(11)
head.next.next = Node.new(13)
head.next.next.next = Node.new(5)
head.next.next.next.next = Node.new(6)
head.next.next.next.next.next = Node.new(7)

puts "Old list: "
print_link_list(head)
puts

head = MergeSort.sort(head)

puts "New list: "
print_link_list(head)

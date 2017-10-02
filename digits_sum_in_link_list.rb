require 'byebug'

class Node
  attr_accessor :next, :value

  def initialize(value = nil)
    self.value = value
  end
end

class LinkedList
  attr_accessor :head

  def add(element)
    node = Node.new(element)
    unless head
      self.head = node
    else
      current_node = head
      until current_node.next.nil?
        current_node = current_node.next
      end
      current_node.next = node
    end

  end
end



list1 = LinkedList.new
list1.add 6
list1.add 1
list1.add 7

list2 = LinkedList.new
list2.add 1
list2.add 2
list2.add 9




def addLists(l1, l2)
  result = nil

  if l1.next != nil && l2.next != nil
    result = addLists(l1.next, l2.next)
  end

  if result.nil?
    digit_sum = l1.value + l2.value
    node = Node.new
    node.value = digit_sum % 10
    carry = digit_sum / 10
    return {list: node, carry: carry }
  else
    digit_sum = l1.value + l2.value + result[:carry]
    node = Node.new
    node.value = digit_sum % 10
    carry = digit_sum / 10
    node.next = result[:list]
    return {list: node, carry: carry }

  end
end

res = addLists(list1.head, list2.head)
debugger
true



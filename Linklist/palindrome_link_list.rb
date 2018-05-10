require 'byebug'

class Node
  attr_accessor :next, :value

  def initialize(value = nil)
    self.value = value
  end
end

class LinkedList
  attr_accessor :head, :length

  def add(element)
    self.length ||= 0
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
    self.length += 1
  end

  def show
    if head
      current_node = head
      until current_node.next.nil?
        # print "#{current_node.value} -> "
        print "#{current_node.value} "
        current_node = current_node.next
      end
      print "#{current_node.value}\n"

    else
      puts 'Null'
    end
  end
end

list1 = LinkedList.new
list1.add 0
list1.add 1
list1.add 2
list1.add 3
list1.add 2
list1.add 1
list1.add 0

# list1.show
# puts list1.length


def palindrome?(node, length)
  print " #{node.value}"
  if length == 1
    puts ""
    return {node: node.next, outcome: true}
  elsif length == 2
    puts ""
    if node.value == node.next.value
      return {node: node.next.next, outcome: true}
    else
      return {outcome: false}
    end
  elsif length == 0
    puts 'NA'
  end

  result = palindrome?(node.next, length - 2)

  # print " #{result[:node] && result[:node].value} , #{result[:outcome]} | "
  print " #{result[:node] && result[:node].value} "
  if result[:node].nil? || !result[:outcome]
    return {outcome: result[:outcome] }
  else
    if result[:node].value == node.value
      return {node: result[:node].next, outcome: true}
    else
      return {node: result[:node].next, outcome: false}
    end
  end
end

result = palindrome?(list1.head, list1.length)

puts ""
puts result[:outcome]
# debugger
# true



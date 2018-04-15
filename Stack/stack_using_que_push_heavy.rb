# Push operation will be heavy

class Stack
  attr_reader :q1, :q2

  def initialize
    @q1 = Queue.new
    @q2 = Queue.new
  end

  def push(element)
    q2.enq element
    while !q1.empty?
      q2.enq q1.deq
    end
    @q1, @q2 = q2, q1
    return true
  end

  def pop
    if q1.empty?
      puts 'Empty Stack!'
      return false
    end
    q1.deq
  end
end

stack = Stack.new
stack.push 1
stack.push 2
stack.push 3
puts stack.pop
stack.push 4
stack.push 5
puts stack.pop

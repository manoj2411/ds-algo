# deque operation is heavy

class MyQueue

  def initialize
    @stack1 = []
    @stack2 = []
  end

  def enque(element)
    @stack1.push element
  end

  def deque
    if @stack2.empty?
      until @stack1.empty?
        @stack2.push @stack1.pop
      end
      return -1 if @stack2.empty?
    end
    @stack2.pop
  end
end

queue = MyQueue.new
queue.enque 2
queue.enque 3
puts queue.deque
queue.enque 4
puts queue.deque
puts ''
queue = MyQueue.new
queue.enque 2
puts queue.deque
puts queue.deque
queue.enque 4

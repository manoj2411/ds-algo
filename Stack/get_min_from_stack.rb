class Stack

  attr_reader :min, :arr

  def initialize
    @arr = []
    @min = nil
  end

  def empty?
    arr.empty?
  end

  def push(x)
    if empty?
      self.min = x
    end
    if x < min
      next_min = (2 * x) - min
      arr << next_min
      self.min  = x
    else
      arr << x
    end
    return x
  end

  def pop
    raise 'Stack is Empty' if empty?
    popped = arr.pop
    if popped < min
      tmp = (min * 2) - popped
      popped = min
      self.min = tmp
    end
    return popped
  end

  private
    attr_writer :min
end

stack = Stack.new

stack.push 10
stack.push 20
stack.push 2
stack.push 4
stack.push 40
puts "Min: #{stack.min}"
puts "Pop #{stack.pop}"
puts "Pop #{stack.pop}"
puts "Min: #{stack.min}"
puts "Pop #{stack.pop}"
puts "Min: #{stack.min}"
puts "Pop #{stack.pop}"
puts "Min: #{stack.min}"
puts "Pop #{stack.pop}"
puts "Push #{stack.push 20}"
puts "Min: #{stack.min}"

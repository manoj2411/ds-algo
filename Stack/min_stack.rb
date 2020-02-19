# Min Stack
# Design a stack that supports push, pop, top, and retrieving the minimum element in constant time

class MinStack

    def initialize()
        @stack = []
    end

    def push(x)
        curr_min = @stack.empty? || @stack.last.last > x ? x : @stack.last.last
        @stack.push([x, curr_min])
    end

    def pop()
        @stack.pop
    end

    def top()
        @stack.last.first
    end

    def get_min()
        @stack.last.last
    end
end




min_stack = MinStack.new();
min_stack.push -10
min_stack.push 14
puts min_stack.get_min
puts min_stack.get_min
min_stack.push -20
puts min_stack.get_min
puts min_stack.get_min
puts min_stack.top
puts min_stack.get_min
min_stack.pop
min_stack.push 10
min_stack.push -7
puts min_stack.get_min
min_stack.push -7
min_stack.pop
puts min_stack.top
puts min_stack.get_min
min_stack.pop

puts "-"  * 10

min_stack = MinStack.new();
min_stack.push(-2);
min_stack.push(0);
min_stack.push(-3);
puts min_stack.get_min(); #  --> Returns -3.
min_stack.pop();
puts min_stack.top();    #  --> Returns 0.
puts min_stack.get_min(); #  --> Returns -2.

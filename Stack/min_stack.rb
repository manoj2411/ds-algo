# Min Stack
# Design a stack that supports push, pop, top, and retrieving the minimum element in constant time
#
# https://leetcode.com/problems/min-stack/
#
class MinStack

    def initialize()
        @stack = []
        @min_stack = []
    end

    def push(x)
        @min_stack << x if @stack.empty? || x <= @min_stack.last
        @stack << x
    end

    def pop()
        x = @stack.pop
        @min_stack.pop if x == @min_stack.last
    end

    def top()
        @stack.last
    end

    def get_min()
        @min_stack.last
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

# Output: -10, -10, -20, -20, -20, -20, -10, -7, -10

# ----------

puts "-"  * 10

min_stack = MinStack.new();
min_stack.push(-2);
min_stack.push(0);
min_stack.push(-3);
puts min_stack.get_min(); #  --> Returns -3.
min_stack.pop();
puts min_stack.top();    #  --> Returns 0.
puts min_stack.get_min(); #  --> Returns -2.

# Output: -3, 0, -2

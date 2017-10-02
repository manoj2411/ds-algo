require './DS/stack'
require 'byebug'

def sort_using_stacks(s1, s2)
  while( !s1.empty?)
    item = s1.pop
    # byebug
    while !s2.empty? && s2.peek < item
      s1.push s2.pop
    end
    s2.push item
  end
end

s1 = Stack.new
s2 = Stack.new

s1.push 2
s1.push 4
s1.push 3
s1.push 0
s1.push 5
s1.push 1

puts "\n - S1 - \n"
s1.display

sort_using_stacks(s1, s2)

puts "\n - S1 - \n\n"
s1.display

puts "\n - S2 - \n\n"
s2.display

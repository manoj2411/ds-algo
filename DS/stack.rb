class Stack
  attr_accessor :length

  def initialize
    @storage = []
    @length = 0
  end

  def push(element)
    @storage.push element
    self.length += 1
  end

  def peek
    @storage[current_index]
  end

  def pop
    element = @storage.pop
    self.length -= 1
    puts "Poped: #{element}"
    element
  end

  def empty?
    @storage.empty?
  end

  def display
    puts 'Stack Elements: '
    @storage.each do |element|
      puts element
    end
  end

  private
    def current_index
      length - 1
    end

end

# s1 = Stack.new

# s1.push 1
# s1.push 23
# s1.push 242
# s1.push 'sdf'
# s1.push 2

# s1.display

# puts "\nPOP 2 elements "

# s1.pop
# s1.pop
# puts "\n"
# s1.display

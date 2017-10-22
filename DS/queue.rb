require 'byebug'

class Queue
  attr_reader :list

  def initialize()
    @list = []
  end

  def enqueue(element)
    @list.push element
  end

  def dequeue
    @list.delete_at(0)
  end

  def size
    list.size
  end

  def head
    @list[0]
  end

  def tail
    @list.last
  end
end


# queue = Queue.new
# queue.enqueue 2
# queue.enqueue 4
# queue.enqueue 6
# queue.enqueue 8

# debugger

# true

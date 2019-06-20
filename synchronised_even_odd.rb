class SynchronisedEvenOdd
  attr_reader :mutex, :resource, :limit

  def initialize(limit = 10)
    @mutex = Mutex.new
    @resource = ConditionVariable.new
    @limit = limit
  end

  def print_numbers
    threads = []
    threads << create_odd_thread
    threads << create_even_thread
    threads.each(&:join)
  end

  def create_even_thread
    Thread.new do
      i = 2
      while i <= limit
        mutex.synchronize {
          resource.wait(mutex)
          puts "Thread 2: The number is '#{i}'"
          i += 2
          resource.signal
        }
      end
    end
  end

  def create_odd_thread
    Thread.new do
      i = 1
      while i < limit
        mutex.synchronize {
          resource.signal
          puts "Thread 1: The number is '#{i}'"
          i += 2
          resource.wait(mutex)
        }
      end
    end
  end

end

SynchronisedEvenOdd.new.print_numbers

class PrintEvenOdd
  attr_reader :max
  def initialize(max = 30)
    @max = max
  end

  def start
    @odd_thread = create_odd_thread
    @even_thread = create_even_thread
    @odd_thread.join
    @even_thread.join
  end

  private 
    def create_odd_thread
      Thread.new do 
        i = 1
        while i <= max
          puts "[thread1] #{i}"
          i += 2
          true while @even_thread.nil?
          @even_thread.wakeup
          Thread.stop
        end
      end
    end

    def create_even_thread
      Thread.new do 
        i = 2
        while i <= max
          Thread.stop
          puts "[thread2] #{i}"
          i += 2
          @odd_thread.wakeup
        end
      end
    end
end

PrintEvenOdd.new.start

# class SynchronisedEvenOdd
#   attr_reader :mutex, :resource, :limit

#   def initialize(limit = 30)
#     @mutex = Mutex.new
#     @resource = ConditionVariable.new
#     @limit = limit
#   end

#   def print_numbers
#     # threads = []
#     # threads << create_odd_thread
#     # threads << create_even_thread
#     # threads.each(&:join)
#     t1 = create_odd_thread
#     Thread2 = create_even_thread
#     t1.join
#     t2.join
#   end

#   def create_odd_thread
#     Thread.new do
#       i = 1
#       puts "Thread1: starting..."
#       while i < limit
#         mutex.synchronize {
#           # resource.signal
#           puts "Thread1: #{i}"
#           i += 2
#           resource.signal
#           puts "Thread1: waiting..."
#           resource.wait(mutex)
#         }
#       end
#     end
#   end

#   def create_even_thread
#     Thread.new do
#       i = 2
#       puts "Thread2: starting..."
#       while i <= limit
#         mutex.synchronize {
#           puts "Threadd2: waiting..."
#           resource.wait(mutex)
#           puts "Thread2: #{i}"
#           i += 2
#           resource.signal
#         }
#       end
#     end
#   end

# end

# SynchronisedEvenOdd.new.print_numbers

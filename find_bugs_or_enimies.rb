class TaskList
  attr_reader :length,

  def initialize
    @arr = []
    @recently_sorted = false
    @length = 0
  end

  def add(difficulty)
    @recently_sorted = false
    @arr << difficulty
    @length += 1
  end

  def list(arr)
    @arr = arr
  end

  def print_n_by_3
    if length < 3
      puts 'Not enough enemies'
      return
    end

    # @arr.sort! {|a,b| b <=> a } unless @recently_sorted

    # puts @arr[(length / 3) - 1]
    puts last_nth(@arr, (length / 3) - 1)
    @recently_sorted = true
  end


  def quick_sort(arr, min, max, store)
    if min < max && store[:res] == nil
      mid = partition(arr, min, max)

      if mid == store[:n]
        # puts "arr: #{arr}"
        store[:res] = arr[mid]
        return
      end
      # if store[:n] < mid
        quick_sort(arr, min, mid - 1, store)
      # else
        quick_sort(arr, mid + 1, max, store)
      # end
    end
  end

  def partition(arr, low, high)
    left_indx = low
    i = low
    pivot = arr[high]
    while i <= (high - 1)
      if arr[i] < pivot
        arr[left_indx], arr[i] = arr[i], arr[left_indx]
        left_indx += 1
      end
      i += 1
    end
    arr[left_indx], arr[high] = pivot, arr[left_indx]
    return left_indx
  end

  def last_nth(arr, n)
    store = {n: n}
    quick_sort(arr, 0, arr.length - 1, store)
    return  store[:res]
  end

end


# total_tasks = gets.chomp.to_i
tasks = TaskList.new

# total_tasks.times do
#   task, difficulty = gets.chomp.split(' ')

#   if task == '1'
#     tasks.add(difficulty.to_i)
#   elsif task == '2'
#     tasks.print_n_by_3
#   end
# end


arr = [10, 6, 12, 1, 4, 2, 3]
tasks.list(arr)# = [10, 6, 12, 1, 4, 2, 3]
puts "Original Array: #{arr}"
puts tasks.last_nth(arr, 4)
puts "Sorted Array: #{arr}"

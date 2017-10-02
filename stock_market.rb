# list_size = gets.chomp.to_i

def max_profit(stock_prices, start = 0, tail = nil, list_size = nil )
  # puts "stock_prices: #{stock_prices.to_s} start: #{start}, tail: #{tail}, list_size: #{list_size}"
  # puts

  if list_size.nil? or tail.nil?
    list_size = stock_prices.size
    tail = list_size - 1
  end
  return if start == tail


  max_at = tail
  min_at = start
  start.upto(tail) do |index|
    # puts "index: #{index}: #{stock_prices[max_at]}"
    max_at = index if stock_prices[max_at] < stock_prices[index]
    min_at = index if stock_prices[min_at] > stock_prices[index]
  end


  if min_at < max_at
    max_profit(stock_prices, start, (min_at - 1), list_size) if min_at > start
    show_result(min_at, max_at)
    max_profit(stock_prices, (max_at + 1), tail, list_size) if max_at < tail
  else

    t_max_at = sum_wrt_min = 0
    (min_at + 1).upto(tail - 1) do |index|
      sum = stock_prices[index] - stock_prices[min_at]
      if sum > sum_wrt_min
        sum_wrt_min = sum
        t_max_at = index
      end
    end

    t_min_at = sum_wrt_max = 0
    (max_at - 1).downto(start) do |index|
      sum = stock_prices[max_at] - stock_prices[index]
      if sum > sum_wrt_max
        sum_wrt_max = sum
        t_min_at = index
      end
    end

    if sum_wrt_max > sum_wrt_min
      # [t_min_at, max_at]
      show_result(t_min_at, max_at)
    else
      # [min_at, t_max_at]
      show_result(min_at, t_max_at)
    end
   end
end

def show_result(min, max)
  puts "#{min} #{max}" if min < max
end

max_profit [4,3,9,8,6,5,4,3,2,1,3,4,2]

# max_profit [100, 180, 260, 310, 40, 535, 695, 200, 210]

#!/usr/bin/ruby

require 'pry'

# marr = [[15, 0.37], [36, 3.51], [65, 3.72], [72, 1.89], [120, 0.20]]
# marr = [[28, 0.38], [140, 4.90], [313, 2.77], [400, 4.32], [446, 2.54], [485, 1.97]]

# marr = [[1, 0.08] , [2, 0.03]]



COST = 0.08
def find_max_profit(marr, len)
  _s = _e = _start = _end = 0
  _max = max_profit = marr[_start][1] - COST

  for i in 1...len
    i_profit = marr[i][1] - COST
    changes = false
    if _end == i - 1
      if max_profit < max_profit + i_profit - ((marr[i][0] - marr[_end][0] - 1) * COST )
        changes = true
        max_profit = max_profit + i_profit - ((marr[i][0] - marr[_end][0] - 1) * COST )
        _end = i
      end
    end
    if i_profit > max_profit
      changes = true
      max_profit = i_profit
      _start = _end = i
    end
    unless changes
      if _max < max_profit
        _max = max_profit
        _s = _start
        _e = _end
      end
      _start = _end = i
      max_profit = i_profit
    end
  end
  if _max < max_profit
    _max = max_profit
    _s = _start
    _e = _end
  end
  puts _max > 0 ? "#{_max.round(2)} #{marr[_s][0]} #{marr[_e][0]}" : 'no profit'
end


input = gets.chomp.to_i
while input != 0
  marr = []
  input.times do
    arr = gets.chomp.split(' ')
    marr << [arr[0].to_i, arr[1].to_f]
  end
  find_max_profit(marr, input)
  input = gets.chomp.to_i
end




# class MinDistanceFinder

#   def initialize(matrix, n, k)
#     @n, @k, @matrix = n, k, matrix
#     @min_distance = n
#     @input = Array.new(k)
#   end

#   def n_bits(n)
#     if (n <= 0)
#       # @input
#       process
#     else
#       @input[n - 1] = 0
#       n_bits(n - 1)
#       @input[n - 1] = 1
#       n_bits(n - 1)
#     end
#   end

#   def process
#     distance = 0
#     @matrix.each do |row|
#       sum = 0
#       i = 0
#       while i < @k
#         sum += row[i] * @input[i]
#         i += 1
#       end
#       # bin_bit = sum % 2
#       # codeword << sum % 2
#       # distance += 1 if bin_bit == 1
#       distance += 1 if sum % 2 == 1
#       # break if distance == min_distance
#     end

#     # distance = codeword.count(1)
#     # puts "#{bin_input} - #{distance} -- #{codeword}"
#     if distance > 0 and distance < @min_distance
#       @min_distance = distance
#     end
#   end

#   def get_min_distance
#     n_bits(@n)
#     @min_distance == @k ? 0 : @min_distance
#   end

# end

# def process(matrix, n, k)
#   # puts "\nMatrix: "
#   # matrix.each { |row| puts row.to_s }
#   # puts

#   # min_distance = n
#   # arr = Array.new(k)

#   # [0,1].repeated_permutation(k).each do |bin_input|
#   #   # print bin_input.to_s
#   #   # codeword = []

#   # end

#   # puts min_distance == k ? 0 : min_distance
# end

# gets.chomp.to_i.times do
#   n, k = gets.chomp.split(' ').map(&:to_i)
#   # puts
#   matrix = []
#   n.times do
#     matrix << gets.chomp.split(' ').map(&:to_i)
#   end
#   # process(matrix, n, k)
#   obj = MinDistanceFinder.new(matrix, n, k)
#   puts obj.get_min_distance
# end

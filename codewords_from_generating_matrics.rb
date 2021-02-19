#!/usr/bin/ruby

# https://youtu.be/iQsKdtjwtYI?t=181


# STDIN.each_line do |line|
#     nums = line.scan(/\d+/).map(&:to_i)
#     a = nums[0]
#     b = nums[1]
#     res = (a - b).abs
#     puts res
# end

# STDIN.each_line do |line|
#   for i in 1...line.length
#     if line[i] == 's' and line[i - 1] == 's'
#       puts 'hiss'
#       exit
#     end
#   end
#   puts 'no hiss'
# end

def product(matrix, input, k)
  matrix.map do |row|
    sum = 0
    0.upto(k - 1) do |i|
      sum += row[i] * input[i]
    end
    sum % 2
  end
end

def process(matrix, n, k)
  # puts "\nMatrix: "
  # matrix.each { |row| puts row.to_s }
  # puts
  min_distance = k
  [0,1].repeated_permutation(k).each do |bin_input|
    # print bin_input.to_s
    codeword = product(matrix, bin_input, k)
    distance = codeword.count(1)
    # puts " - #{distance} -- #{codeword}"
    if distance > 0 and distance < min_distance
      min_distance = distance
    end
  end
  puts min_distance == k ? 0 : min_distance
end

gets.chomp.to_i.times do
  n, k = gets.chomp.split(' ').map(&:to_i)
  # puts
  matrix = []
  n.times do
    matrix << gets.chomp.split(' ').map(&:to_i)
  end
  process(matrix, n, k)
end

# STDIN.each_line do |line|
# while true
  # line = gets.chomp
  # arr = line.split(' ')
  # exit if arr.length != 2

  # s, l = arr
  # llen = l.length
  # slen = s.length

  # puts "#{get_type1(l, s, llen, slen)} #{get_type2(l, s, llen, slen)} #{get_type3(l, s, llen, slen)}"
# end


# STDIN.read / STDOUT.write

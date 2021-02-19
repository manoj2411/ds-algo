#!/usr/bin/ruby

class MinDistanceFinder

  def initialize(matrix, n, k)
    @n, @k, @matrix = n, k, matrix
    @min_distance = n
    @input = Array.new(k)
  end

  def n_bits(n)
    if (n <= 0)
      # @input
      process
    else
      @input[n - 1] = 0
      n_bits(n - 1)
      @input[n - 1] = 1
      n_bits(n - 1)
    end
  end

  def process
    distance = 0
    ri = 0
    while ri < @n
    # @matrix.each do |row|
      # row = @matrix[xi]
      sum = 0
      i = 0
      while i < @k
        # sum += row[i] * @input[i]
        sum += @matrix[ri][i] * @input[i]

        i += 1
      end
      distance += 1 if sum % 2 == 1
      ri += 1
    end

    if distance > 0 and distance < @min_distance
      @min_distance = distance
    end
  end

  def get_min_distance
    n_bits(@n)
    @min_distance == @k ? 0 : @min_distance
  end

end

gets.chomp.to_i.times do
  n, k = gets.chomp.split(' ').map(&:to_i)
  matrix = []
  n.times do
    matrix << gets.chomp.split(' ').map(&:to_i)
  end
  obj = MinDistanceFinder.new(matrix, n, k)
  puts obj.get_min_distance
end

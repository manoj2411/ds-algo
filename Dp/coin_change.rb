def how_many_way_to_change(arr, sum)
  if !arr.is_a?(Array) || arr.empty? || !sum.is_a?(Numeric) || sum <= 0
    return -1
  end
  # rows = sum from 0 to sum
  # cols = arr
  mat = Array.new(sum + 1) { Array.new(arr.length)}

  # fill in 1st row for base case. Since first row represent sum 0 means
  # irrespective of what set has, we will have 1 ways to get sum 0 i.e.
  # by not choosing any element from set
  for i in 0...arr.length
    mat[0][i] = 1
  end

  for i in 1..sum
    for j in 0...arr.length
      # soln including current element i.e. arr[j]
      x = arr[j] <= i ? mat[i - arr[j]][j] : 0
      # soln including not current element i.e. arr[j]
      y = j > 0 ? mat[i][j - 1] : 0
      mat[i][j] = x + y
    end
  end

  return mat[sum][arr.length - 1]
end


[[[1,2,3], 4], [[2, 5, 3, 6], 10]].each do |input|
  puts "Input: #{input[0]} - #{input[1]}"
  puts "Result: #{how_many_way_to_change *input}"
end

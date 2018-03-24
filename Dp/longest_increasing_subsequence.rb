def lis(arr)
  i = 1
  result = Array.new(arr.length, 0)
  result[0] = 1

  while i < arr.length
    max_length = 0
    0.upto (i - 1) do |j|
      if arr[j] < arr[i] && result[j] > max_length
        max_length = result[j]
      end
    end
    result[i] = max_length + 1
    i += 1
  end
  return result.max
end

[[10,22,9,33,21,50,41,60,80], [0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15],
[3, 10, 2, 1, 20],[3, 2], [50, 3, 10, 7, 40, 80]].each do |arr|
  puts "Arr: #{arr} - lis: #{lis(arr)}"
end

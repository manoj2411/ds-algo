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


# Alternate implementation
def lenght_of_lis(arr)
  lis = Array.new arr.length
  lis[0] = 1
  for i in 1...arr.length
    max_i = find_max_i(arr, lis, arr[i],  i - 1)
    if max_i >= 0
      lis[i] = lis[max_i] + 1
    else
      lis[i] = 1
    end
  end
  return lis.max
end

def find_max_i(arr, lis, key, r)
  max_i = -1
  for i in 0..r
    if arr[i] < key
      if max_i == -1 || lis[max_i] < lis[i]
        max_i = i
      end
    end
  end
  return max_i
end

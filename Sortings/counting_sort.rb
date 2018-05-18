# Counting Sort
# ---
# - keys between a specific range
# - works by counting the number of objects having distinct key values

def counting_sort(arr)
  max = arr.max + 1
  counts = Array.new(max, 0)

  # count elements
  arr.each do |element|
    counts[element] += 1
  end

  # do cummulative sum and change counts array
  for i in 1...max
    counts[i] += counts[i - 1]
  end

  # build result
  result = Array.new(arr.length)

  arr.each do |element|
    counts[element] = indx = counts[element] - 1
    result[indx] = element
  end
  return result
end

for arr in [[1, 4, 1, 2, 7, 5, 2], [1, 4, 1, 2, 7, 0, 2], [9,4,10,8,2,4]]
  puts "Arr: #{arr}"
  puts "Sorted: #{counting_sort arr}"
  puts
end

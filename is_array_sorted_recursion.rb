def isArraySorted?(array, size)
  # puts "size:#{size}"
  # puts "array: #{array[0...size]}"
  # puts ""
  if size == 1
    return 1
  end

  if array[size - 1] < array[size - 2]
    return 0
  else
    isArraySorted?(array, size - 1)
  end
end

arr = [4,2,1,3,6]

isArraySorted?(arr, arr.length)

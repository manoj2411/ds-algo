def sort(arr)
  mid = 0
  start = -1
  high = arr.length

  while mid < high
    if arr[mid] > 1
      high -= 1
      tmp = arr[high]
      arr[high] = arr[mid]
      arr[mid] = tmp
    elsif arr[mid] < 1
      start += 1
      tmp = arr[start]
      arr[start] = arr[mid]
      arr[mid] = tmp
      mid += 1
    else
      mid += 1
    end
  end
end

arr = [2,2,1,0,1,2,0,1,1,2,2,0,0,1,0]
arr = [2,2,0,1,1,0,1,1,0,1,2,1,0]

puts 'Sorted Array: '
sort(arr)
puts arr.join(', ')

def find_median(arr)
  max = 0
  curr_max = 0
  finding_max = true

  (1...arr.length).each do |i|
    if finding_max
      if arr[i] <= arr[max]
        next
      end
      finding_max = false
      curr_max = max = i
    else
      if arr[i] > arr[max]
        if arr[i] > arr[curr_max]
          curr_max = i
        end
        next
      else
        finding_max = true
        max = curr_max

      end
    end
  end

  return (finding_max == false and max < arr.length - 1) ? arr[max] : -1
end

# Refactored and Optimised

def get_mid(arr)
  max = 0
  point = -1
  (1...arr.length).each do |indx|
    if arr[indx] > arr[max]
      point = indx if point == -1
      max = indx
    elsif (point >= 0 && arr[indx] > arr[point])
      next
    else
      point = -1
    end
  end

  return (point == (arr.length - 1) || point == -1) ? -1 : arr[point]
end

[[5, 1, 4, 4],[5, 1, 4, 3, 6, 8, 10, 7, 9], [4,2,5,7], [11,9,12], [4,3,5,2,7,9,8]].each do |arr|
  puts "Arr: #{arr}"
  puts "Point: #{get_mid(arr)}"
end


# puts find_median([1,2,3,4,3,2,1])
# puts find_median([4,2,5,7])
# puts find_median([11,9,12])
# puts find_median([4,3,2,7,9,8])
# puts find_median([5, 1, 4, 3, 6, 8, 10, 7, 9])
# puts find_median([5, 1, 4, 4])



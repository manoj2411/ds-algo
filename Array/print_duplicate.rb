def print_deplicates(arr)
  max = arr.length - 1
  0.upto(max) do |i|
    if arr[arr[i].abs] > 0
      arr[arr[i].abs] = -arr[arr[i].abs]
    # else
      # puts arr.to_s
    end
  end
  arr.each_with_index do |element, indx|
    print "#{indx} " if element < 0
  end
end

arr = [1, 3, 3, 1, 3, 6, 6]
print_deplicates(arr)
puts

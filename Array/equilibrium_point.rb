def find_equilibrium_point(arr)
  sum = 0
  0.upto(arr.length - 1).each do |i|
    sum += arr[i]
  end
  left_sum = 0
  0.upto(arr.length - 1).each do |i|
    sum -= arr[i]
    if sum == left_sum
      puts "Found quilibrium index at #{i}"
      return
    end
    left_sum += arr[i]
  end
end

arr = [-7, 1, 5, 2, -4, 3, 0]
# arr = [1, 2, 3, 3]
arr = [1,3,4,10,18,3,1,6,3,1,4]
# arr =  [-1, 3, -4, 5, 1, -6, 2, 1 ]

find_equilibrium_point(arr)

def redix_sort(arr)
  max_num = arr.max

  return arr if max_num <= 0

  exp = 10
  while max_num > 0
    arr = counting_sort(arr, exp)
    max_num /=  10
    exp *= 10
  end
  return arr
end

def counting_sort(arr, exp)
  len = arr.length
  digits = Array.new(10, 0)

  # set digit counts
  arr.each do |num|
    curr_digit = (num % exp) / (exp / 10)
    digits[curr_digit] += 1
  end
  # convert to cummulative sum
  for i in 1..9
    digits[i] += digits[i - 1]
  end

  result = Array.new(len)
  # fill up result array
  (len - 1).downto(0) do |i|
    ele = arr[i]
    curr_digit = (ele % exp) / (exp / 10)
    indx = digits[curr_digit] - 1
    result[indx] = ele
    digits[curr_digit] -= 1
  end
  # puts ": #{result}"
  return result
end


for arr in [[170,45,75,90,802,24,2,66], [12,11,13,5,6,7], [38,27,43,3,9,82,10]]
  puts "Arr: #{arr}"
  puts "Sorted: #{redix_sort arr}"
  puts
end

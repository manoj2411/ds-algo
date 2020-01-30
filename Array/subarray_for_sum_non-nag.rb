=begin
  So there are some very tricky cases to miss, those are:
    1 when the give sum is 0
    2 when given sum equal to last element or last few elements
    3 when give sum is always less than the elements given
    4 when given sum greater than sum of all numbers

  So the biggest learning is: before checking given_sum and current_sum always make
    sure that current_sum has at least 1 item included otherwise it'll break the case 1.
    Where are we checking equal condition is also very important, think about it carefully
    and do a manual process on paper then simuate the flow on code and think about the
    places where we want to check/compare, also when to include/exclude elements in current_sum
=end
def subarray_with_sum(arr, given_sum)
  start = i = curr_sum = 0

  while i < arr.length

    if start == i # curr_sum doesn't have any item, so just add the current item
      curr_sum += arr[i]
      i += 1
    end

    while curr_sum < given_sum && i < arr.length
      curr_sum += arr[i]
      i += 1
    end

    while curr_sum > given_sum
      curr_sum -= arr[start]
      start += 1
    end

    next if start == i # it means we haven't selected any item in curr_sum, it'll break when given sum is 0

    return start, i - 1 if curr_sum == given_sum
  end
  -1
end

def subarray_with_sum_old(arr, given_sum)
  start = 0
  i = 1
  sum = arr[start]

  # since the value of sum is adjusted after comparing the given_sum, we need 1 more
  #  iteration to reach to the sum & given_sum comparision.
  while i <= arr.length
    #  start < (i - 1) making sure that we are not removing all the items from sum
    #   with this there will be always a gap of at least 1 in start & i
    while sum > given_sum && start < (i - 1)
      sum -= arr[start]
      start += 1
    end

    if given_sum == sum
      # puts "The lies between #{start} and #{i - 1 }"
      return start, i - 1
    end

    if i < arr.length
      sum += arr[i]
    end
    i += 1
  end
  # puts "start: #{start} i: #{i}"
  # puts "No subarray found! "
  -1
end



for arr, sum in [
  [[1,2,3,7,5], 12], # [1,3]
  [[1,2,3,7,5], 15], # [2,4]
  [[1,2,3,7,5], 27], # -1
  [[1,2,3,7,5], 2],  # [1,1]
  [[1,2,3,4,5,6,7,8,9,10], 15], # [0,4]
  [[1,4,20,3,10,5], 33], # [2,4]
  [[1,4,0,0,3,10,5],7], # [1,4]
  [[2,4], 1], # -1
  [[1,4], 0], # -1

]
  puts "Arr: #{arr}, sum: #{sum}"
  puts subarray_with_sum(arr, sum).to_s
  puts
end


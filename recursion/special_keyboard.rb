def print_max_a(n)
  # When n <= 6, the max result will be the number itself, can be prooved by
  # examples / test cases
  #
  return n if n <= 6

  max = 0

  # when n is greater than 6, we need to find a point from where we just
  # select the screen, copy to clipboard and do pastes
  # minimum can be 3 i.e. select copy and paste it'll just doubles the count
  # whatever visible on screen
  #
  # till point calculation can be retrived from recursion
  #
  # Here i will be - min operations of select-copy-paste (3)
  i = n - 3
  # i will go down to 2 and try to find max value treating i as optimal point
  while i > 1
    # if n is 7, i will be 4 * (it should be 2 bcz 1 for f(1) & 1 for paste)
    # =>  f(4) * (7 - 4 - 1)
    res = print_max_a(i) * (n - i - 1)
    max = res if max < res
    i -= 1
  end
  return max
end


(1..15).each do |i|
  puts "#{i} - #{print_max_a i}"
end

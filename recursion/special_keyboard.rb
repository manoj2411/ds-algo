def print_max_a(n)
  return n if n <= 6

  max = 0

  i = n - 3
  while i > 1
    res = print_max_a(i) * (n - i - 1)
    max = res if max < res
    i -= 1
  end
  return max
end


(1..15).each do |i|
  puts "#{i} - #{print_max_a i}"
end

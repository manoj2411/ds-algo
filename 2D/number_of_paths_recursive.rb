def no_of_paths(m, n)
  return 1 if m == 1 || n == 1
  return no_of_paths(m - 1, n) + no_of_paths(m, n - 1)
end

puts "3 X 3 - #{no_of_paths(3, 3)}"
puts "2 X 8 - #{no_of_paths(2, 8)}"

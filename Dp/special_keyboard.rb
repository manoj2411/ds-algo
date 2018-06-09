def print_max_a(n)
  return 0 if n <= 0

  if n <= 6
    return n
  end

  tmp = (0..6).to_a
  for i in 7..n
    max = 0
    for j in 2..(i - 3)
      res = tmp[j] * (i - j - 1)
      max = res if max < res
    end
    tmp[i] = max
  end
  return tmp[n]
end

for n in [3,7, 11]
  puts "Input: #{n}"
  puts "Output: #{print_max_a n}"
end

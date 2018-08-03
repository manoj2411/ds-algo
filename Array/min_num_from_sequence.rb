def form_min_number(str)
  return -1 if str.nil? || str.empty?

  res = str[0] == 'I' ? [1,2] : [2,1]

  k = 3

  for i in 1...str.length
    curr = str[i]

    if curr == 'I'
      res << k
    else
      stack = []
      j = i - 1
      while j > 0 && str[j] == curr
        stack << res.pop
        j -= 1
      end

      stack << res.pop
      stack << res.pop if j == 0
      res << k

      while not stack.empty?
        res << stack.pop
      end
    end
    k += 1
  end

  return res.join
end

for input in ['D', 'I', 'DD', 'II', 'DIDI', 'IIDDD', 'DDIDDIID']
  puts "-> #{input} - #{form_min_number input}"
end

def find_stock_span(arr)
  len = arr.length
  res = Array.new(len)
  res[0] = 1
  stack = []
  stack.push(0)

  for i in 1...len
    while !stack.empty? && arr[stack.last] <= arr[i]
      stack.pop
    end

    res[i] = stack.empty? ? i + 1 : i - stack.last
    stack.push(i)
  end

  return res
end


for arr in [[100, 80,60,70,60,75,85]]
  puts "Arr: #{arr}"
  puts "Span: #{find_stock_span arr}"
end

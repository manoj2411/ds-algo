def form_largest_number(arr)
  arr.sort do |a,b|
    num1 = "#{a}#{b}".to_i
    num2 = "#{b}#{a}".to_i
    num2 <=> num1
  end.join
end


[[1, 34, 3, 98, 9, 76, 45, 4, 121, 12], [12, 121], [121, 12]].each do |arr|
  puts "\nArr: #{arr}"
  puts form_largest_number(arr)
end

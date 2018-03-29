def form_largest_number(arr)
  arr.sort do |a,b|
    num1 = "#{a}#{b}".to_i
    num2 = "#{b}#{a}".to_i
    num2 <=> num1
  end.join
end

def form_largest_number_new(arr)
  max_length = arr.max.to_s.length
  pairs = arr.map do |num|
    pair = [num]
    str = num.to_s
    pair << (str * ((max_length / str.length) + 1))[0..max_length].to_i
  end

  pairs.sort {|a,b| b[1] <=> a[1] }.map {|lst| lst[0] }.join('')
end


[[1, 34, 3, 98, 9, 76, 45, 4, 121, 12], [12, 121], [121, 12]].each do |arr|
  puts "\nArr: #{arr}"
  puts "Method1: "
  puts form_largest_number(arr)
  puts "Method2: "
  puts form_largest_number_new(arr)
end

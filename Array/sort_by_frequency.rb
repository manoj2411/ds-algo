def sort_by_frequesncy(arr)
  hs = Hash.new(0)

  arr.each {|e| hs[e] += 1 }
  new_arr = hs.map{|num,count| [count, num]}
  new_arr.sort! do |a,b|
    if a[0] != b[0]
      b[0] <=> a[0]
    else
      a[1] <=> b[1]
    end
  end
  puts 'Sorted array: '
  new_arr.each do |pair|
    pair[0].times { print "#{ pair[1]} "}
  end
  puts
end


arr = [2, 5, 2, 8, 5, 6, 8, 8]

puts "Arr: #{arr}"
sort_by_frequesncy(arr)

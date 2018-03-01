def convert(arr)
    0.upto(arr.length - 2) do |i|
        if ((i % 2 == 0 ) && (arr[i] > arr[i + 1])) || (i % 2 == 1 && arr[i] < arr[i + 1])
            arr[i], arr[i+1] = arr[i+1], arr[i]
        end
    end
end

[[4,3,7,8,6,2,1], [1,4,3,2]].each do |arr|
    puts "List: #{arr}"
    convert(arr)
    puts "Converted: #{arr}\n\n"
end

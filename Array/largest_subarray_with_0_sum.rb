def largest_sub_arr_len(arr)
    max_len = 0
    hs = {}
    cummulative_sum = 0
    arr.each_with_index do |item, indx|
        cummulative_sum += item
        if item == 0 and max_len == 0
            max_len = 1
        end

        if cummulative_sum == 0
            max_len = indx + 1
        end

        if hs[cummulative_sum]
            # puts "cummulative_sum: #{cummulative_sum}, hs: #{hs}"
            max_len = [max_len, indx - hs[cummulative_sum]].max
            next
        end
        hs[cummulative_sum] = indx
    end
    return max_len
end

[[15,-2,2,-8,1,7,10,23], [1, 2, 3,-6], [0, 1]].each do |arr|
    puts "Arr: #{arr}"
    puts "Largest subarray length: #{largest_sub_arr_len(arr)}"
    puts
end

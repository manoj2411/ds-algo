def find_leaders(a)
    i = a.length - 1
    curr_max = -1
    result = []

    while i >= 0
        result << curr_max = a[i] if a[i] >= curr_max
        i -= 1
    end
    result.reverse
end

for arr in [
    [16,17,4,3,5,2], # 17, 5, 2
    [7,4,5,7,3], # 7,7,3
    [], # []
    [2], # [2]
    [1,2,3,4,0], # 4, 0
]

    puts "Leaders in array: #{arr}"
    puts find_leaders(arr).to_s

end

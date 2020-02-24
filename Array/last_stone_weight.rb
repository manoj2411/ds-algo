def last_stone_weight(stones)
    # first 2 largest stones
    # l1, l2 = find_2_largest(stones, stones.length - 1)

    # if l1 == l2 destroy both
    # otherwise bigger - smaller

    i = stones.length - 1

    while i > 0
        if stones[0] > stones[1]
            l1 = 0
            l2 = 1
        else
            l1 = 1
            l2 = 0
        end

        for j in 2..i
            if stones[j] >= stones[l1]
                l2 = l1
                l1 = j
            elsif stones[j] > stones[l2]
                l2 = j
            end
        end

        if stones[l1] == stones[l2]
            stones[l1], stones[i] = stones[i], stones[l1]
            i -= 1
            stones[l2], stones[i] = stones[i], stones[l2]
            i -= 1
        else
            stones[l1] -= stones[l2]
            stones[l2], stones[i] = stones[i], stones[l2]
            i -= 1
        end

    end

    i == 0 ? stones[0] : 0
end

# [2,7,4,1,8,1] -> [2,4,1,1,1] -> [2,1,1,1] -> [1,1,1] -> [1]

for input in [
    [2,7,4,1,8,1], # 1
]

    puts "Input: #{input}"
    puts "Res: #{last_stone_weight input}"
end

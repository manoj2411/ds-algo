def string_shift(s, shift)
    length = s.length
    final_shift_amount = 0
    for direction, amount in shift
        if direction == 0
            final_shift_amount -= amount
        else
            final_shift_amount += amount
        end
    end

    str_i = nil
    if final_shift_amount < 0
        str_i = final_shift_amount.abs
    elsif final_shift_amount > 0
        str_i = length - (final_shift_amount % length)
    else # when final_shift_amount is 0
        return s
    end

    result = Array.new(length)
    length.times do |i|
        result[i] = s[str_i % length]
        str_i += 1
    end
    result.join
end


for str, shifts in [
    ["abc", [[0,1],[1,2], [1,3]]], # "cab"
    ["abcdefg", [[1,1],[1,1],[0,2],[1,3]]], # "efgabcd"
]
    puts string_shift(str, shifts)
end

def hamming_distance(x, y)

    # compare last significat bit of both numbers and then left shift both
    diff = 0
    while x > 0 || y > 0
        diff += 1 if x % 2 != y % 2
        # puts "#{x}, #{y} - - #{x % 2}, #{y % 2}"
        x >>= 1
        y >>= 1
    end
    diff
end

puts hamming_distance(1, 4) # 2

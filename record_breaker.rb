t = gets.chomp.to_i
for i in 0...t
    n = gets.chomp.to_i
    next if n == 0
    visitors = gets.chomp.split(' ').map(&:to_i)
    next if n != visitors.length

    # prev_max = -1
    # c = 0
    # for v in 1...n
    #     if visitors[v-1].to_i > prev_max && visitors[v-1].to_i > visitors[v].to_i
    #         c += 1
    #     end
    #     prev_max = [prev_max, visitors[v-1].to_i].max
    # end

    # c += 1 if visitors[v].to_i > prev_max
    def get_record_braking_days(v, n)
        max = 0
        res = 0

        for i in 0..(n - 2)
            if v[i] > max
                max = v[i]
                res += 1 if v[i] > v[i + 1]
            end
        end
        res += 1 if v[n - 1] > max
        res
    end

    puts "Case ##{i+1}: #{get_record_braking_days(visitors, n)}"
end

# def get_record_braking_days(v, n)

#     max = 0
#     res = 0

#     for i in 0..(n - 2)
#         if v[i] > max
#             max = v[i]
#             res += 1 if v[i] > v[i + 1]
#         end
#     end
#     res += 1 if v[n - 1] > max
#     res
# end


# t = gets.chomp.to_i


# t.times.map do |ti|
#     n = gets.chomp.to_i
#     visitors = gets.chomp.split(" ").map(&:to_i)
#     get_record_braking_days(visitors, n)
# end.each_with_index do |records, i|
#     puts "Case ##{i + 1}: #{records}"
# end

#  2 0 7 2 0 2 0 => 2,7
#
# 4 8 15 16 23 42 => 42
#
# 3 1 4 1 5 9 2 6 5 => 4, 5, 9
#
#

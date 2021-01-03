require "set"

#   https://leetcode.com/problems/count-good-meals/
#

# @param {Integer[]} deliciousness
# @return {Integer}
def count_pairs(deliciousness)
    good_meals = []
    num = 1
    max = deliciousness.max

    while num <= max * 2 && num <= (10 ** 9) + 7
        good_meals << num
        num <<= 1
    end

    map = {}
    res = 0

    deliciousness.each do |d|
        good_meals.each do |meal|
            if map[meal - d]
                res += map[meal - d]
            end
        end
        map[d] ||= 0
        map[d] += 1
    end

    res % 1_000_000_007
end


puts count_pairs([1,3,5,7,9]) # 4
puts count_pairs([1,1,1,3,3,3,7]) # 15
puts count_pairs([149,107,1,63,0,1,6867,1325,5611,2581,39,89,46,18,12,20,22,234]) # 12
puts count_pairs([64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64,64]) # 528

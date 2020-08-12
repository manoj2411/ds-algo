# https://leetcode.com/problems/pascals-triangle-ii/
# Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
#
def get_row(row_index)
    res = Array.new(row_index + 1, 1)

    for i in 2..row_index
       j = i - 1
        while j > 0
            res[j] += res[j - 1]
            j -= 1
        end
    end
    res
end


for i in 0..10
    puts get_row(i).to_s
end

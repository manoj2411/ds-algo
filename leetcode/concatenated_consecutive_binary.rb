# https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/

# @param {Integer} n
# @return {Integer}
def concatenated_binary(n)
    res = 0
    max = (10 ** 9) + 7
    len = 0

    for i in 1..n
        # idea is to keep len of binary i and increment it when i becomes
        #  power of 2 like 1,2,8,16 etc. That is when len of binary increases.

        len += 1 if i & (i - 1) == 0
        curr = (res << len) | i
        res = curr % max
    end
    res

end

puts concatenated_binary(1)     # 1
puts concatenated_binary(3)     # 27
puts concatenated_binary(6)     # 14126
puts concatenated_binary(12)    # 505379714
puts concatenated_binary(122)   # 996327204
puts concatenated_binary(99999) # 880407397
puts concatenated_binary(100000)# 757631812

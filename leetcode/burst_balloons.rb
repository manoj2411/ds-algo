#       https://leetcode.com/problems/burst-balloons/
#
#
# @param {Integer[]} nums
# @return {Integer}
def max_coins(nums)
    len = nums.length

    return 0 if len == 0

    cache = Array.new(len + 2) { Array.new(len + 2) }
    helper([1] + nums + [1], 0, nums.length + 1, cache);
end

=begin

    We are using top down DP here. Idea is to always assume L & R always present and
    select a P from  L + 1 to R - 1 and this P will be the last ballon to burst from the given range which means
    coins for current P will be
        (A[P] * A[L] * A[R]) + solution from L to P + solution from P to R

    NOTE: the range helper never include L & R elements, we are only taking care of elements between them.
=end
def helper(nums, l, r, cache)

    if r - l == 1
        0
    elsif cache[l][r]
        cache[l][r]
    else
        max = 0

        for p in (l + 1)..(r - 1)
            # assume p_th will be last ballon to burst
            curr = nums[p] * nums[l] * nums[r] +
                    helper(nums, l, p, cache) +
                    helper(nums, p, r, cache)
            max = curr if curr > max
        end
        cache[l][r] = max
    end
end


for arr in [
    [3,1,5,8], # 167
    [4,6,3,12,7,1,10], # 2136
]
    puts "Arr: #{arr}"
    puts "Result: #{max_coins(arr)}"
    puts
end

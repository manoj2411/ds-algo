#You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.
#
# Given n, find the total number of full staircase rows that can be formed.
#
# @param {Integer} n
# @return {Integer}
def arrange_coins(n)
    nxt = 1
    curr = 0
    val = 0

    while val + curr < n
       curr = nxt
        val += nxt
        nxt += 1
    end
    curr
end


for n in [
    5, # 2
    8, # 3
    0, # 0
    1, # 1
    3, # 2
]
    puts arrange_coins(n)
end

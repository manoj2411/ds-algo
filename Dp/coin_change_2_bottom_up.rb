# Coin Change 2
#
# Find number of combinations that make up that amount.
# Assume that you have infinite number of each kind of coin.

def change(amount, coins)
    dp = Array.new(coins.length + 1) { Array.new(amount + 1, 0) }

    for i in 0..coins.length
        dp[i][0] = 1
    end

    for i in 1..coins.length

        for s in 1..amount
            dp[i][s] =
                if s < coins[i - 1]
                    dp[i - 1][s]
                else
                    dp[i - 1][s] + dp[i][s - coins[i - 1]]
                end
        end
    end

    dp.last.last
end


for amt, coins in [
    [5, [1, 2, 5]], # 4
    [3, [2]], # 0
    [10, [10]], # 1
    [0, []], # 1
    [155, [1,2,3,4,5,10,15,20,25]], # 5856725
]
    puts change(amt, coins)
end

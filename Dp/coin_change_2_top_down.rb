# Coin Change 2
#
# Find number of combinations that make up that amount.
# Assume that you have infinite number of each kind of coin.

def change(amount, coins)
    cache = Array.new(coins.length) { Array.new(amount) }
    util(amount, coins, 0, cache)
end

def util(amount, coins, i, cache)
    if amount == 0
        1
    elsif i == coins.count
        0
    elsif cache[i][amount]
        cache[i][amount]
    elsif coins[i] > amount
        cache[i][amount] = util(amount, coins, i + 1, cache)
    else
        cache[i][amount] =
            util(amount, coins, i + 1, cache) +
            util(amount - coins[i], coins, i, cache)
    end

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

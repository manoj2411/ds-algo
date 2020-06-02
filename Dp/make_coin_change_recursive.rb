def make_change(coins, sum, cache = {})
    return 0 if sum == 0
    return cache[sum] if cache[sum]

    min_coins = Float::INFINITY
    coins.each do |coin|
        next if coin > sum
        no_of_coins = 1 + make_change(coins, sum - coin, cache)
        min_coins = no_of_coins if no_of_coins < min_coins
    end
    cache[sum] = min_coins
end

for coins, sum in [
    [[1,6,10].shuffle, 12], # 2
    [[1,6,10].shuffle, 112], # 12
    [[1,5,10,25].shuffle, 1], #1
    [[1,5,10,25].shuffle, 49], # 7
]
    puts "Coins: #{coins}, Sum: #{sum}, no of coins: #{make_change(coins, sum)}"
end

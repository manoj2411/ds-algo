def make_change(coins, sum)
    cache = Array.new(sum + 1)
    cache[0] = 0 # soting base result; no coins when sum 0

    for curr_sum in 1..sum
        min_coins = Float::INFINITY

        coins.each do |coin|
            next if coin > curr_sum
            no_of_coins = 1 + cache[curr_sum - coin]
            min_coins = no_of_coins if no_of_coins < min_coins
        end

        cache[curr_sum] =  min_coins
    end
    cache[sum]
end

for coins, sum in [
    [[1,6,10].shuffle, 12], # 2
    [[1,6,10].shuffle, 112], # 12
    [[1,5,10,25].shuffle, 1], #1
    [[1,5,10,25].shuffle, 49], # 7
]
    puts "Coins: #{coins}, Sum: #{sum}, no of coins: #{make_change(coins, sum)}"
end


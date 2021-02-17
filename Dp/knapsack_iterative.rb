# 0/1 - knapsack : find max value with the given weight we can carry. Items quantity is 1.
def knapsack(items, weight)
  length = items.length
  dp = Array.new(length + 1) { Array.new(weight + 1, 0 ) }

  for i in 1..length
    for curr_w in 1..weight

      dp[i][curr_w] =
        if items[i - 1][:w] > curr_w
          dp[i - 1][curr_w] # weight is greater, can't consider curr wt & val
        else
          curr_val = items[i - 1][:v]
          curr_weight = items[i - 1][:w]
          [
            dp[i - 1][curr_w], # do not include curr weight & value
            curr_val + dp[i - 1][curr_w - curr_weight] # include curr weight & value
          ].max
        end

    end
  end

  dp[length][weight]
end

items = [{w:2, v:6}, {w:2, v:10}, {w:3, v:12}]
max_weight = 5
puts knapsack(items, max_weight) # 22

items = [{w:1, v:1}, {w:3, v:4}, {w:4, v:5}, {w:5, v:7}]
max_weight = 7
puts knapsack(items, max_weight) # 9

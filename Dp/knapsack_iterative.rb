# find max value with the given weight we can carry. Items quantity is 1.
def knapsack(items, weight)
  length = items.length
  cache = Array.new(length + 1) { Array.new(weight + 1, 0 ) }

  for i in 1..length
    for curr_w in 1..weight

      cache[i][curr_w] =
        if items[i - 1][:w] > curr_w
          cache[i - 1][curr_w]
        else
          [
            cache[i - 1][curr_w],
            cache[i - 1][curr_w - items[i - 1][:w]] + items[i - 1][:v]
          ].max
        end

    end
  end

  cache[length][weight]
end

items = [{w:2, v:6}, {w:2, v:10}, {w:3, v:12}]
max_weight = 5
puts knapsack(items, max_weight) # 22

items = [{w:1, v:1}, {w:3, v:4}, {w:4, v:5}, {w:5, v:7}]
max_weight = 7
puts knapsack(items, max_weight) # 9

# 0/1 - knapsack : find max value with the given weight we can carry. Items quantity is 1.
def knapsack(items, weight)
  util(items, weight, 0, {})
end

def util(items, weight, i, cache)
  if i == items.length
    0
  elsif cache[[i,weight]]
    cache[[i,weight]]
  else
    result =
      if items[i][:w] > weight
        util(items, weight, i + 1, cache) # can't fit curr weight, get result without considering curr wt & curr val
      else
        [
          util(items, weight, i + 1, cache), # do not include curr wt & val
          items[i][:v] + util(items, weight - items[i][:w], i + 1, cache) # include curr wt & val
        ].max
      end
    cache[[i,weight]] = result
    cache[[i,weight]]
  end
end

items = [{w:2, v:6}, {w:2, v:10}, {w:3, v:12}]
max_weight = 5
puts knapsack(items, max_weight) # 22

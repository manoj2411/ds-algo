def pp(mat)
  mat.each {|row| puts row.to_s }
end

def knapsack(wt, val, w)
  n = wt.length
  t = Array.new(n) { Array.new(w + 1) }

  for i in 0...n
    t[i][0] = 0
  end

  for i in 0..w
    if i >= wt[0]
      t[0][i] = val[0]
    else
      t[0][i] = 0
    end
  end

  for i in 1...n
    for j in 1..w
      if j >= wt[i]
        t[i][j] = [ val[i] + t[i - 1][j - wt[i]], # including ith element in result
                    t[i - 1][j] # exluding ith element from result
                  ].max
      else
        t[i][j] = t[i - 1][j]
      end
    end
  end
  pp t
  return t[n - 1][w]
end


# val = [60, 100, 120]
# wt = [10, 20, 30]
# weight = 50
wt = [4,1,3,5]
val = [5,1,4,7]
weight = 7
puts knapsack(wt, val, weight)

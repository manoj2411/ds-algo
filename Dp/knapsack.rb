# 0/1 - knapsack : find max value with the given weight we can carry. Items quantity is 1.
def pp(mat)
  mat.each {|row| puts row.to_s }
end

def knapsack(wt, val, w)
  n = wt.length # assuming length of weight and values lists are of same length
  t = Array.new(n) { Array.new(w + 1) }

  # Filling t matrix 0 positions, case is if the given W (weight) is 0 then we can't
  #   pick anythings and the result will always be 0
  for i in 0...n
    t[i][0] = 0
  end

  # Filling first in comparison with first element.
  #   - Its 1 of the approaches to apply the algo steps e.x. t[i - 1][j]. We are not
  #       choosing current element and just taking the result without it, to support
  #       it we have do this setup and fill in first row for first element.
  #   - There alternate approach can be is to create matrix with 1 more row and fill in the
  #       first row with 0 and then in login iser i + 1 while filling the rows for t[](t matrix)
  for i in 0..w
    if i >= wt[0]
      t[0][i] = val[0]
    else
      t[0][i] = 0
    end
  end

  for i in 1...n
    for j in 1..w
      # Find out max of with and without current element only if current weight
      #   i.e. j is greater then or equal to weight of current element i.e. (wt[i])
      # Otherwise just not choose the current element v[i] and copy result without
      #   current element which is is available at t[i - 1][j]
      if j >= wt[i]
        t[i][j] = [
                    val[i] + t[i - 1][j - wt[i]], # including ith element in result
                    t[i - 1][j] # excluding ith element from result
                  ].max
      else
        t[i][j] = t[i - 1][j]
      end
    end
  end
  # pp t
  return t[n - 1][w]
end


# val = [60, 100, 120]
# wt = [10, 20, 30]
# weight = 50
wt = [4,1,3,5]
val = [5,1,4,7]
weight = 7
puts knapsack(wt, val, weight)

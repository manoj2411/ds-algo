# Problem
#
# Given an array, make max points with given rules:
# 1. Choose an element X from array, delete all it occurances from array and
#    add every entry to points.
# 2. Now delete all elements from array that are plus/minus 1 to X.
#     Delete all X - 1 and X + 1, no change in points
# 3. Do this until array is empty
#
# ex: [1, 2, 1, 3, 2, 3] - max points will be 1 + 1 + 3 + 3 => 8

def maxPoints(elements)
    hsh = Hash.new(0)
    elements.each {|e| hsh[e] += 1 }
    arr = []
    hsh.each_pair {|num, count| arr << [num, num * count] }
    arr = arr.sort_by{|e| e[0] }
    n1 = arr[0][1]
    return n1 if arr.length == 1

    if arr[1][0] - arr[0][0] == 1
      n2 = [arr[1][1], n1].max
    else
      n2 = arr[1][1] + n1
    end

    return n2 if arr.length == 2
    # binding.pry
    res = 0
    for i in 2...arr.length
      if arr[i][0] - arr[i - 1][0] == 1
         res = [n2, arr[i][1] + n1].max
      else
        res = n2 + arr[i][1]
      end
      n1 = n2
      n2 = res
    end

    return res
end

for arr in [[1, 5, 1, 3, 5, 3], [1, 2, 1, 3, 2, 3]]
    puts "Input: #{arr}"
    puts "Points: #{maxPoints(arr)}"
end


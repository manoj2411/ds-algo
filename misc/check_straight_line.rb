# Constraints:
#
# 2 <= coordinates.length <= 1000
# coordinates[i].length == 2
# -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
# coordinates contains no duplicate point.

def check_straight_line(coordinates)
  return 2 if coordinates.length == 2
  x1, y1 = coordinates[0]
  x2, y2 = coordinates[1]
  for i in 2...coordinates.length
    x3, y3 = coordinates[i]
    return false if ((x3 - x1) * (y2-y1)) != ((y3 - y1) * (x2 - x1))
  end
  true
end


for input in [
  [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]], #true
  [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]], # false
]
  puts check_straight_line(input)
end

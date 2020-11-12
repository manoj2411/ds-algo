##  https://leetcode.com/problems/valid-square/

# @param {Integer[]} p1
# @param {Integer[]} p2
# @param {Integer[]} p3
# @param {Integer[]} p4
# @return {Boolean}
def valid_square(p1, p2, p3, p4)

    x = dist(p1, p2)
    y = dist(p1, p3)
    z = dist(p1, p4)
    lenghts = {}
    lenghts[x] ||= []
    lenghts[x] << p2
    lenghts[y] ||= []
    lenghts[y] << p3
    lenghts[z] ||= []
    lenghts[z] << p4

    return false if lenghts.size != 2

    # puts lenghts.to_s
    opposite_point = lenghts.find {|k, v| v.length == 1}[1].first
    adj_distance, points = lenghts.find {|k, v| v.length == 2 }
    adj_p1, adj_p2 = points


    # all 4 sides are equal and length of diagnals are also equal
    dist(opposite_point, adj_p1) == adj_distance &&
    dist(opposite_point, adj_p2) == adj_distance &&
    dist(p1, opposite_point) == dist(adj_p1, adj_p2)
end

def dist(p1, p2)
    # sqrt of (x2 - x1) ** 2 + (y2 - y1) ** 2
   Math.sqrt( ((p1[0] - p2[0]) ** 2) + ((p1[1] - p2[1]) ** 2) )
end


## Tests

points = [[1,1], [5,3], [3,5], [7,7]] # false
puts valid_square(*points)

points = [[1,1], [0,0], [1,0], [0,1]] # true
puts valid_square(*points)

points = [[8,0], [12,0], [10,2], [10,-2]] # true
puts valid_square(*points)

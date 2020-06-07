def min_cost(houses, cost, m, n, target)
    result =
        if houses[0] > 0
            util(houses, cost, m, n, target, 1, 0, 1)
        else
            min = Float::INFINITY
            for j in 0...n
                houses[0] = j + 1
                curr = util(houses, cost, m, n, target, 1, cost[0][j], 1)
                min = curr if min > curr
            end
            min
        end
    result == Float::INFINITY ? -1 : result
end

def util(houses, cost, m, n, target, i, cc, grp)
    if grp > target
        # puts "houses: #{houses}, cc: #{cc}, target: #{target}, grp #{grp}"
        Float::INFINITY
    elsif i == m
        # puts "houses: #{houses}, cc: #{cc}, grp #{grp}"
        grp == target ? cc : Float::INFINITY
    elsif houses[i] > 0
        grp += 1 if houses[i] != houses[i - 1]
        util(houses, cost, m, n, target, i + 1, cc, grp)
    else
        min = Float::INFINITY
        for j in 0...n
            grp_size = (houses[i - 1] == j + 1 ? grp : grp + 1)
            houses[i] = j + 1
            curr = util(houses, cost, m, n, target, i + 1, cc + cost[i][j], grp_size)
            min = curr if curr < min
            houses[i] = 0
        end
        min
    end

end

houses = [0,0,0,0,0]; cost = [[1,10],[10,1],[10,1],[1,10],[5,1]]; m = 5; n = 2; target = 3
puts min_cost(houses, cost, m, n, target) # 9

houses = [3,1,2,3]; cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]]; m = 4; n = 3; target = 3
puts min_cost(houses, cost, m, n, target) # -1̆

houses = [0,0,0,0,0]; cost = [[1,10],[10,1],[1,10],[10,1],[1,10]]; m = 5; n = 2; target = 5
puts min_cost(houses, cost, m, n, target) # 5

houses = [0,2,1,2,0]; cost = [[1,10],[10,1],[10,1],[1,10],[5,1]]; m = 5; n = 2; target = 3
puts min_cost(houses, cost, m, n, target) # 11

# wrong answer usecase with caching
#
# houses = [4,0,0,0,4,11,0,0,0,0,3,0,0,0,0,5,0,0,0,0,0,8,2,2,0]
# cost = [[33,13,38,3,25,10,49,9,10,36,39,3],[47,19,6,37,2,23,50,18,46,14,24,33],[32,31,32,17,36,41,43,29,36,29,47,3],[25,27,5,31,1,17,27,46,10,8,31,49],[50,16,33,24,42,2,33,39,43,31,2,38],[38,6,23,18,9,13,31,36,28,7,7,1],[40,23,21,5,48,2,18,24,6,27,39,44],[25,43,4,9,5,5,30,42,23,41,7,15],[45,32,44,15,5,1,2,43,49,30,29,4],[39,26,42,45,27,28,41,6,42,27,4,43],[32,2,43,13,15,30,32,12,36,5,19,22],[12,23,13,8,8,9,32,43,46,41,43,8],[10,18,27,2,7,40,44,50,32,29,42,10],[50,7,15,9,32,9,15,10,15,41,10,36],[48,6,26,6,14,37,44,47,4,44,1,30],[34,46,12,32,19,1,18,31,1,16,44,48],[15,35,17,14,16,29,23,18,28,26,45,17],[43,45,7,39,37,18,18,33,24,47,27,46],[17,12,15,20,44,34,14,8,28,40,12,21],[18,10,15,47,21,7,47,34,37,49,16,24],[19,3,38,14,32,21,4,25,34,3,33,23],[21,45,3,49,45,40,38,10,30,5,37,21],[29,38,43,22,44,26,3,18,45,40,40,17],[21,12,30,23,4,25,32,43,37,15,35,30],[38,14,6,21,3,43,43,30,9,19,39,17]]
# m = 25
# n = 12
# target = 15
# puts solution(houses, cost, m, n, target) # 105

# time out usecase
#
# houses =[4,0,0,0,4,11,0,0,0,0,3,0,0,0,0,5,0,0,0,0,0,8,2,2,0]
# cost =[[33,13,38,3,25,10,49,9,10,36,39,3],[47,19,6,37,2,23,50,18,46,14,24,33],[32,31,32,17,36,41,43,29,36,29,47,3],[25,27,5,31,1,17,27,46,10,8,31,49],[50,16,33,24,42,2,33,39,43,31,2,38],[38,6,23,18,9,13,31,36,28,7,7,1],[40,23,21,5,48,2,18,24,6,27,39,44],[25,43,4,9,5,5,30,42,23,41,7,15],[45,32,44,15,5,1,2,43,49,30,29,4],[39,26,42,45,27,28,41,6,42,27,4,43],[32,2,43,13,15,30,32,12,36,5,19,22],[12,23,13,8,8,9,32,43,46,41,43,8],[10,18,27,2,7,40,44,50,32,29,42,10],[50,7,15,9,32,9,15,10,15,41,10,36],[48,6,26,6,14,37,44,47,4,44,1,30],[34,46,12,32,19,1,18,31,1,16,44,48],[15,35,17,14,16,29,23,18,28,26,45,17],[43,45,7,39,37,18,18,33,24,47,27,46],[17,12,15,20,44,34,14,8,28,40,12,21],[18,10,15,47,21,7,47,34,37,49,16,24],[19,3,38,14,32,21,4,25,34,3,33,23],[21,45,3,49,45,40,38,10,30,5,37,21],[29,38,43,22,44,26,3,18,45,40,40,17],[21,12,30,23,4,25,32,43,37,15,35,30],[38,14,6,21,3,43,43,30,9,19,39,17]]
# m = 25
# n = 12
# target = 15
# puts solution(houses, cost, m, n, target)

def island_perimeter(grid)
    result = 0
    n = grid.length
    return result if n == 0

    m = grid.first.length


    for i in 0...n
        for j in 0...m
            result += find_boundries(grid, i, j, n, m) if grid[i][j] == 1
        end
    end
    result
end

def find_boundries(grid, i, j, n, m)
    boundries = 4
    boundries -= 1 if i + 1 < n and grid[i + 1][j] == 1
    boundries -= 1 if i - 1 >= 0 and grid[i - 1][j] == 1
    boundries -= 1 if j + 1 < m and grid[i][j + 1] == 1
    boundries -= 1 if j - 1 >= 0 and grid[i][j - 1] == 1
    boundries
end

for m in [
    [], # 0
    [[0]], # 0
    [[0,0]], # 0
    [[1]], # 4
    [[1,1]], # 6
    [[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]], # 16
    [[1,1,1,0],[0,1,1,0],[0,1,1,1],[0,0,1,0]], # 16
]

    puts island_perimeter(m)

end

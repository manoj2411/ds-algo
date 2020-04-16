def count_squares(matrix)
    result = 0
    rows = matrix.length
    cols = matrix[0].length

    for i in 0...rows
        for j in 0...cols
            next if matrix[i][j] == 0
            if i != 0 && j != 0
                min = [
                    matrix[i - 1][j - 1],
                    matrix[i - 1][j],
                    matrix[i][j - 1]
                ].min

                matrix[i][j] += min
            end
            result += matrix[i][j]
        end
    end
    result
end
for m in [
    [[0,1,1,1],[1,1,1,1],[0,1,1,1]], # 15
    [[1,0,1], [1,1,0],[1,1,0]], # 7
    [[0,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1],[1,1,1,1,1]], # 36
]
    puts "Matrix:"
    m.each {|r| puts r.to_s}
    puts count_squares(m)
end

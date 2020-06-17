def solve(board)
    row_len = board.length
    return if row_len <= 2
    col_len = board.first.length
    return if col_len <= 2

    for i in 0...row_len
        block_adjacents(board, row_len, col_len, i, 0) if board[i][0] == 'O'
        block_adjacents(board, row_len, col_len, i, col_len - 1) if board[i][col_len - 1] == 'O'
    end

    for j in 0...col_len
        block_adjacents(board, row_len, col_len, 0, j) if board[0][j] == 'O'
        block_adjacents(board, row_len, col_len, row_len - 1, j) if board[row_len - 1][j] == 'O'
    end

    for i in 0...row_len
        for j in 0...col_len
            if board[i][j] == 'O'
                board[i][j] = 'X'
            elsif board[i][j] == '*'
                board[i][j] = 'O'
            end
        end
    end
end

def block_adjacents(board, rowlen, collen, i, j)
    board[i][j] = '*'
    block_adjacents(board, rowlen, collen, i + 1, j) if i + 1 < rowlen && board[i + 1][j] == 'O'
    block_adjacents(board, rowlen, collen, i - 1, j) if i - 1 >= 0 && board[i - 1][j] == 'O'
    block_adjacents(board, rowlen, collen, i, j - 1) if j - 1 >= 0 && board[i][j - 1] == 'O'
    block_adjacents(board, rowlen, collen, i, j + 1) if j + 1 < collen && board[i][j + 1] == 'O'
end


board = [
    ["X","X","X","X"],
    ["X","O","O","X"],
    ["X","X","O","X"],
    ["X","O","X","X"]
]

solve(board)
puts "Result: "
board.each { |r| puts r.to_s }

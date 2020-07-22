# Word Search - https://leetcode.com/problems/word-search/
#
def exist(board, word)
    row_len = board.length
    col_len = board.first.length
    word_len = word.length
    visited = Array.new(row_len) { Array.new(col_len)}

    for i in 0...row_len
        for j in 0..col_len
            if board[i][j] == word[0]
                if has_word?(board, word, i, j, row_len, col_len, word_len, visited, 0)
                    return true
                end
            end
        end
    end
    false
end

def has_word?(board, word, r, c, row_len, col_len, word_len, visited, i)
    return true if i == word_len - 1

    visited[r][c] = true

    find_next(r, c, row_len, col_len).each do |nextr, nextc|
        if !visited[nextr][nextc] &&
            board[nextr][nextc] == word[i + 1] &&
            has_word?(board, word, nextr, nextc, row_len, col_len, word_len, visited, i + 1)

            return true
        end
    end

    visited[r][c] = false
    false
end

def find_next(i, j, rows, cols)
    res = []
    res << [i + 1, j] if i + 1 < rows
    res << [i - 1, j] if i - 1 >= 0
    res << [i, j + 1] if j + 1 < cols
    res << [i, j - 1] if j - 1 >= 0
    res
end


for board, word, exp_result in [
    [[["a"],["c"],["b"]],"a", true], #
    [[["a"],["c"],["b"]],"b", true], #
    [[["a"],["c"],["b"]],"c", true], #
    [[["a"],["c"],["b"]],"ac", true], #
    [[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],"ABCCED", true], #
    [[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],"SEE", true], #
    [[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]],"ABCB", false], #
    [[["A","B","C","E"],["S","F","E","S"],["A","D","E","E"]],"ABCESEEEFS", true], #
]
    puts "Word #{word} : \t #{exist(board, word)} \t[exp: #{exp_result}]"
end

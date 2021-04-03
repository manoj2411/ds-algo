# @param {String[]} strs
# @param {Integer} m
# @param {Integer} n
# @return {Integer}
def find_max_form(strs, m, n)

    counts = strs.map {|str| [str.count("0"), str.count("1")]}

    cache = Array.new(strs.length) { Array.new(m + 1) { Array.new(n + 1) } }

    find_max(counts, 0, m, n, cache)

end

def find_max(arr, i, m, n, cache)
    return 0 if i == arr.length

    zero, one = arr[i]

    cache[i][m][n] ||=
        if zero <= m && one <= n
            [
                find_max(arr, i + 1, m, n, cache),
                1 + find_max(arr, i + 1, m - zero, n - one, cache),
            ].max
        else
            find_max(arr, i + 1, m, n, cache)
        end

    cache[i][m][n]
end

strs, m, n = ["10","0001","111001","1","0"], 5, 3
puts find_max_form(strs, m, n) # 4

strs, m, n = ["10","0","1"], 1, 1
puts find_max_form(strs, m, n) # 2

# 	https://leetcode.com/problems/palindrome-partitioning/
#

# @param {String} s
# @return {String[][]}
def partition(s)
    len = s.length

    res = []
    helper(s, [], res, 0, len)
    res
end

def helper(s, curr, res, start, n)
    if start >= n
        res << curr
        return
    end

    for i in start...n
        if is_palindrom?(s, start, i)
            prefix = s[start..i]
            helper(s, curr + [prefix], res, i + 1, n)
        end
    end
end

def is_palindrom?(str, l, r)
    while(l < r)
        return false if str[l] != str[r]
        l += 1
        r -= 1
    end
    true
end

for str in ["aab", "a", "ababa"]
	puts "String: #{str}"
	puts "Result: #{partition str}"
	puts
end

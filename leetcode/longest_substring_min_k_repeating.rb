##  https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
#
# @param {String} s
# @param {Integer} k
# @return {Integer}
def longest_substring(s, k)
    helper(s, 0, s.length(), k);
end

def helper(s, start, _end, k)
    return 0 if _end < k

    count = Array.new(26, 0)

    char_i = -> (char) { char.ord - 'a'.ord }

    for i  in start..._end
        count[char_i[s[i]]] += 1
    end

    for mid in start..._end
        next if count[char_i.(s[mid])] >= k

        midNext = mid + 1;
        while (midNext < _end && count[ char_i.call(s[midNext]) ] < k)
            midNext += 1
        end

        return [helper(s, start, mid, k), helper(s, midNext, _end, k)].max
    end

    _end - start
end

for input in  [
    ["aaaaaaaaaaaabcdefghijklmnopqrstuvwzyz", 3], # 12
    ["aaabb",3], # 3
    ["bcaaabbc", 3], # 3
    ["bcaaabbc", 2], # 8
]
    puts longest_substring(*input)
end

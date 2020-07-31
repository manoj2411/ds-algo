# https://leetcode.com/problems/word-break-ii/
#
# @param {String} s
# @param {String[]} word_dict
# @return {String[]}
require "set"

def word_break(s, word_dict)
    dict = Set.new(word_dict)
    cache = Array.new(s.length)
    util(s, dict, 0, s.length, cache)
end

def util(s, word_dict, indx, n, cache)
    return cache[indx] if cache[indx]
    result = []
    str = ""

    for i in indx...n
        str += s[i]

        if word_dict.include?(str)
            if i + 1 == n
                result << str
            else
                util(s, word_dict, i + 1, n, cache).each do |word|
                    result << "#{str} #{word}"
                end

            end

        end
    end
    cache[indx] = result
end

for s, dict in [
    ['catsanddog', ["cat", "cats", "and", "sand", "dog"]], #["cats and dog", "cat sand dog"]
    ['pineapplepenapple',["apple", "pen", "applepen", "pine", "pineapple"]], # ["pine apple pen apple", "pineapple pen apple", "pine applepen apple"]
    ['catsandog', ["cats", "dog", "sand", "and", "cat"]], # []
    [
        "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
        ["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
    ], # []
]

    puts word_break(s, dict).to_s
end

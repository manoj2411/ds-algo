# https://leetcode.com/problems/search-suggestions-system/

# @param {String[]} products
# @param {String} search_word
# @return {String[][]}
def suggested_products(products, search_word)
    products.sort!

    result = []

    prefix = ""
    first_index = 0

    search_word.each_char do |ch|

        if first_index.nil?
            result << []
            next
        end

        prefix << ch
        first_index, res = find_products(products, prefix, first_index)
        result << res
    end

    result
end

def find_products(products, prefix, start)
    res = []
    first_index = nil

    for i in start...products.length

        if products[i].start_with? prefix
            first_index ||= i
            res << products[i]

            break if res.length == 3
        elsif first_index
            break
        end
    end

    [first_index, res]
end


puts suggested_products(["bags","baggage","banner","box","cloths"], "bags").to_s
# res : [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]

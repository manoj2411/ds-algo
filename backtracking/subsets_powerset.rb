def subsets(nums)
    result = []
    len = nums.length

    fill_selection(0, len, Array.new(len), result)

    result.map do |selection|
        res = []
        selection.each_with_index do |sel, i|
            res << nums[i] if sel == 1
        end
        res
    end
end

def fill_selection(i, n, curr, result)
    if i == n
        result << curr.clone
        return
    end

    curr[i] = 0
    fill_selection(i + 1, n, curr, result)
    curr[i] = 1
    fill_selection(i + 1, n, curr, result)
end

subsets([1,2,3]).each {|r| puts r.to_s }
# [
#   [3],
#   [1],
#   [2],
#   [1,2,3],
#   [1,3],
#   [2,3],
#   [1,2],
#   []
# ]

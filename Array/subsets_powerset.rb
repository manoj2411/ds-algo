def subsets(nums)
    result = [[]]
    nums.each do |x|
        result += result.map{|r| r + [x] }
    end
    result
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

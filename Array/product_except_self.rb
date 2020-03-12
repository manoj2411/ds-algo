# Product of Array Except Self
def product_except_self(nums)
    left_prod = Array.new(nums.length)
    right_prod = Array.new(nums.length)

    curr_prod = 1
    for i in 0..(nums.length - 1)
        curr_prod *= nums[i]
        left_prod[i] = curr_prod
    end
    curr_prod = 1
    (nums.length - 1).downto(0) do |i|
        curr_prod *= nums[i]
        right_prod[i] = curr_prod
    end

    result = Array.new(nums.length)
    for i in 1..(nums.length - 2)
        result[i] = left_prod[i - 1] * right_prod[i + 1]
    end
    result[0] = right_prod[1]
    result[nums.length - 1] = left_prod[nums.length - 2]

    result
end

for input in [
    [1,2,3,4], # [24,12,8,6]
]
    puts "Input: #{input}"
    puts "Res: #{product_except_self input}"
end

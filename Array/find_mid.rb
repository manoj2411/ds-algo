# Element with left side smaller and right side greater
#
def find_mid(nums)
    n = nums.length

    max_from_left = build_max_from_left(nums, n)
    min_from_right = build_min_from_right(nums, n)

    for i in 1..(n - 2)
        if nums[i] > max_from_left[i - 1] and nums[i] < min_from_right[i + 1]
            return nums[i]
        end
    end

    -1
end


def build_max_from_left(nums, n)
    max = nums.clone
    for i in 1...n
        if max[i] < max[i - 1]
            max[i]  = max[i - 1]
        end
    end
    max
end

def build_min_from_right(nums, n )
    i = n - 2
    mins = nums.clone

    (n - 2).downto(0) do |i|
        if mins[i] > mins[i + 1]
            mins[i] = mins[i + 1]
        end
    end
    mins
end


for arr in [
    [4,2,5,7], # 5
    [11,9,12], # -1
    [4,3,2,7,8,9], # 7
    [5, 1, 4, 3, 6, 8, 10, 7, 9], # 6
    [5, 1, 4, 4], # -1
]
    puts find_mid(arr)
end

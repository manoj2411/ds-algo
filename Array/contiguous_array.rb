# Contiguous Array:
#   Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1

def find_max_length(nums)
    max_len = 0

    _hash = {}
    curr_sum = 0

    for i in 0..(nums.length - 1)
        if nums[i] == 0
            curr_sum -= 1
        else
            curr_sum += 1
        end

        max_len = i + 1 if curr_sum == 0 # MUST for case 0th index is included

        if _hash[curr_sum]
            curr_len = i - _hash[curr_sum]
            max_len = curr_len if curr_len > max_len
        else
            _hash[curr_sum] = i
        end
    end

    max_len
end

for input in [
    [0,1], # 2
    [0,1,0], # 2
    [0,0,0,0,0,1,0,1,0], # 4
    [0,0,0,0,1,0,0,0,1], # 2
    [0,0,1,0,1,0,0,0,0,1,1], # 4
    [0,0,1,0,0,1,0,0,0,1,1], # 6
    [0,0,0], # 0
    [1,1,1], # 0
]

    puts find_max_length input
end

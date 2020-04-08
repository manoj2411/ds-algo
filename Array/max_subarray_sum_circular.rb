# Maximum Sum Circular Subarray
def max_subarray_sum_circular(a)
    len = a.length
    max_sum = max_subarray_sum(a, len)

    total = 0
    for i in 0...len
        total += a[i]
        a[i] = -a[i]
    end
    min_sum = max_subarray_sum(a, len)

    max_sum_circular = total - (-min_sum)
    if max_sum_circular > max_sum && max_sum_circular != 0
        max_sum_circular
    else
        max_sum
    end
end

def max_subarray_sum(a, len)
    res = -Float::INFINITY
    curr_sum = 0
    for i in 0...len
        curr_sum += a[i]
        res = curr_sum if curr_sum > res
        curr_sum = 0 if curr_sum < 0
    end
    res
end


for arr in [
    [-7,1,2,7,-2,-5], # 10
    [1,-2,3,-2],# 3
    [5,-3,5],# 10
    [3,-1,2,-1],# 4
    [3,-2,2,-3],# 3
    [-2,-3,-1], #-1
    [-5,3,5], # 8
    [5,3,-5], # 8
]
    puts max_subarray_sum_circular(arr)
end

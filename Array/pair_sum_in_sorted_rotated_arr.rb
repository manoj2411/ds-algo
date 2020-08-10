def pair_sum(a, x)
    len = a.length

    l, r = rotation_point(a, len)

    while l != r

        if a[l] + a[r] < x
            l += 1
        elsif a[l] + a[r] > x
            r -= 1
        else
            return true
        end

        l = 0 if l == len
        r = len - 1 if r == -1
    end

    false
end


def rotation_point(a, len)
    l = 0
    r = len - 1
    return l, r if a[l] < a[r]

    while r - l > 1
        mid = (r + l ) / 2
        if a[mid] > a[l]
            l = mid
        else
            r = mid
        end
    end
    [r, l]
end





puts pair_sum([11, 15, 6, 8, 9, 10], 16) # true
puts pair_sum([11, 15, 26, 38, 9, 10], 35) # true
puts pair_sum([11, 15, 26, 38, 9, 10], 45) # false
arr = [14, 15, 6, 8, 9, 10]
# arr = [6, 8, 9, 10,14,15]
puts(pair_sum(arr, 16)) # true
puts(pair_sum(arr, 29)) # true
puts(pair_sum(arr, 24)) # true
puts(pair_sum(arr, 21)) # true
puts(pair_sum(arr, 20)) # true
puts(pair_sum(arr, 26)) # false



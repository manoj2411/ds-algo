def find_sum_pair(arr, _sum):
    left = 0
    _len = len(arr)


    for i in range(1, _len):
        if arr[i - 1] > arr[i]:
            left = i
            break
    # end of loop

    right = (left - 1) if left > 0 else (_len - 1)

    while left != right:
        _val = arr[right] + arr[left]
        if _val == _sum:
            return True
        elif _val > _sum:
            right -= 1
            if right == -1:
                right = _len - 1
        else:
            left += 1
            if left == _len - 1 :
                left = 0

    return False


arr = [14, 15, 6, 8, 9, 10]
# arr = [6, 8, 9, 10,14,15]
print(find_sum_pair(arr, 16)) # true
print(find_sum_pair(arr, 29)) # true
print(find_sum_pair(arr, 24)) # true
print(find_sum_pair(arr, 21)) # true
print(find_sum_pair(arr, 20)) # true
print(find_sum_pair(arr, 26)) # false

arr = [11, 15, 26, 38, 9, 10]
print(find_sum_pair(arr, 45)) # false

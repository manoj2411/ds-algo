def find_sum_pair(arr, _sum):
    _min = 0
    _len = len(arr)
    _prev = arr[0]

    for i in range(1, _len):
        if _prev > arr[i]:
            _min = i
            break

        _prev = arr[i]
    # end of loop
    _max = (_min - 1) if _min > 0 else (_len - 1)

    while _min != _max:
        _val = arr[_max] + arr[_min]
        if _val == _sum:
            return True
        elif _val > _sum:
            _max -= 1
            if _max == -1:
                _max = _len - 1
        else:
            _min += 1
            if _min == _len - 1 :
                _min = 0

    return False


arr = [14, 15, 6, 8, 9, 10]
_sum =
# arr = [11, 15, 26, 38, 9, 10]
# _sum = 45
print(find_sum_pair(arr, _sum))

def find_sum_pair(arr, x):
    hs = {}
    for i in arr:
        if x - i in hs :
            return i, x - i
        hs[i] = True

    return 'NA'

arr = [1, 4, 45, 6, 10, -8]
print(find_sum_pair(arr, 37))

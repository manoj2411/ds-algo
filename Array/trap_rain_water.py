def trap_rain_water(arr):
    l = 0
    r = len(arr) - 1
    return tw_util(arr, l, r)

def tw_util(arr, l, r):
    if r - l <= 1 :
        return 0

    mid = get_mid(arr, l, r)

    if mid == -1 :
        return calulate_water_inside(arr, l, r)
    return tw_util(arr, l, mid) + tw_util(arr, mid, r)

def get_mid(arr, l, r):
    for i in range(l + 1, r):
        if (arr[i] > arr[l]) or (arr[i] > arr[r]) :
            return i
    return -1

def calulate_water_inside(arr, l, r):
    _min = min(arr[l], arr[r])
    _sum = 0

    for i in range(l + 1, r):
        _sum += _min - arr[i]
    return _sum


lst = [[6,3,7,4,2,5,6], [3,0,0,2,0,4], [6,5,7,4,0,9], [6,9,9], [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]]

for arr in lst:
    print("List: {}".format(arr))
    print("Trapped rain water: {}\n".format(trap_rain_water(arr)))


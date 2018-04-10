def trap_rain_water(arr):
    left = 0
    right = len(arr) - 1
    sum = 0
    left_max = 0
    right_max = 0


    while left <= right :
        if arr[left] < arr[right] :
            if left_max > arr[left] :
                sum += left_max - arr[left]
            else :
                left_max = arr[left]
            left += 1
        else :
            if right_max > arr[right] :
                sum += right_max - arr[right]
            else :
                right_max = arr[right]
            right -= 1
    return sum

    # Alternavite implementation!
    #
    # i = 1
    # diff = 1
    # if arr[left] > arr[right]:
    #     i = right - 1
    #     diff = -1

    # while i > left and i < right:
    #     # print("S: i {}({}) left {}({}) right {}({})".format(i, arr[i], left, arr[left], right, arr[right]))
    #     if min(arr[left], arr[right]) < arr[i]:
    #         if arr[left] < arr[i]:
    #             left = i
    #         else :
    #             right = i

    #         if arr[left] > arr[right] :
    #             i = right - 1
    #             diff = -1
    #         else:
    #             i = left + 1
    #             diff = 1
    #     else :
    #         result += min(arr[left], arr[right]) - arr[i]
    #         i += diff
    #     # print("E: i {}({}) left {}({}) right {}({})".format(i, arr[i], left, arr[left], right, arr[right]))
    # return result




lst = [[6,3,7,4,2,5,6],[3,0,0,2,0,4], [6,5,7,4,0,9], [6,9,9], [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]]

for arr in lst:
    print("List: {}".format(arr))
    print("Trapped rain water: {}\n".format(trap_rain_water(arr)))


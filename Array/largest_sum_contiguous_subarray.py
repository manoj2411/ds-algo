def largest_sum_of_contiguous_subarr(arr):
    max_so_far = arr[0]
    curr_max = 0
    for i in range(len(arr)):
        curr_max += arr[i]
        if max_so_far < curr_max :
            max_so_far = curr_max
        if curr_max < 0:
            curr_max = 0
    return max_so_far


for arr in [[-2, -3, 4, -1, -2, 1, 5, -3], [1,2,3], [-1,-2,-3,-4]]:
    print("Arr: {}\nResult: {}".format(arr, largest_sum_of_contiguous_subarr(arr)))



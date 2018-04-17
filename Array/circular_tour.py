def cicular_tour(arr):
    start = 0
    n = len(arr)
    curr_sum = arr[start][0] - arr[start][1]
    i = 1

    while start < n:
        # print("i:{}, s:{} sum:{} ".format(i, start, curr_sum))
        if curr_sum < 0:
            curr_sum -= arr[start][0] - arr[start][1]
            start += 1
            continue
        item = arr[i]
        curr_sum += item[0] - item[1]
        if (i + 1) % n == start and curr_sum >= 0:
            return start
        i = (i + 1) % n

    return -1

group = [[[4,6], [6,5], [7,3], [4,5]], [[6, 4], [3, 6], [7, 3]], [[6, 7], [13, 60], [7, 11]]]
for arr in group:
    print("Arr: {}\n{}".format(arr, cicular_tour(arr)))

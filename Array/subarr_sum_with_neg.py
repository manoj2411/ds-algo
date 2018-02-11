def sub_array_sum(arr, _sum):
    cum_sum = 0
    cum_sum_dict = {}

    for i in range(len(arr)):
        cum_sum += arr[i]
        # print("i:{} sum:{} map: {}".format(i, cum_sum, cum_sum_dict))
        if cum_sum == _sum:
            print("Found result between {} and {}".format(0, i))
            return

        if  cum_sum - _sum in cum_sum_dict:
            # print(_sum - cum_sum)
            # print(cum_sum_dict)
            start = cum_sum_dict[cum_sum - _sum] + 1
            print("Found result between {} and {}".format(start, i))
            return

        cum_sum_dict[cum_sum] = i

    print("No result found!")

if __name__ == '__main__':
    # arr = [1,4,20,-3,10,5]
    # _sum = 12
    # arr = [1, 4, 20, 3, 10, 5]
    # _sum = 33
    # arr = [10, 2, -2, -20, 1]
    # _sum = -10
    arr = [-10, 0, 2, -2, -20, 10]
    _sum = 20
    sub_array_sum(arr, _sum)

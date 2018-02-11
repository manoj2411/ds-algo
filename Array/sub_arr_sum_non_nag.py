def subarray_sum(arr, _sum):
    cum_sum = 0
    c_sum_dict = {}
    i = 0
    while i < len(arr):
        curr_sum += arr[i]
        while curr_sum > _sum:
            curr_sum -= arr[min_indx]
            min_indx += 1

        if curr_sum == _sum:
            print("Sub Array found: ")
            print(arr[min_indx:i + 1])
            return

        i += 1



if __name__ == '__main__':
    # subarray_sum([15, 10,6,2,13,7,5], 12)
    subarray_sum([15, 2, 4, 8, 9, 5, 10, 23], 23)

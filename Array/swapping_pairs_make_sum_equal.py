def get_sum(arr):
    return sum(arr)

def swapping_pair_exists(arr1, arr2):
    sum1 = get_sum(arr1)
    sum2 = get_sum(arr2)

    for i in range(len(arr1)):
        for j in range(len(arr2)):
            if sum1 - arr1[i] + arr2[j] == sum2 - arr2[j] + arr1[i]:
                return 1

    return 0


arr1 = [4,1,2,1,1,2]
arr2 = [3,6,3,3]
print("Arr1: {}\nArr2: {}\nResult: {}".format(arr1, arr2, swapping_pair_exists(arr1, arr2)))

arr2 = [1,2,3,8]
arr1 = [5,7,4,6]
print("Arr1: {}\nArr2: {}\nResult: {}".format(arr1, arr2, swapping_pair_exists(arr1, arr2)))

def merge_sort(arr):
    merge_sort_util(arr, 0, len(arr) - 1)

def merge_sort_util(arr, left, right):
    if left == right :
        return
    elif left < right :
        mid = left + ((right - left) / 2)
        merge_sort_util(arr, left, mid)
        merge_sort_util(arr, mid + 1, right)
        merge(arr, left, mid, right)

def merge(arr, left, mid, right):
    arr1 = []
    arr2 = []
    copy_lists(arr, arr1, arr2, left, right, mid)

    i = left
    j = l = 0
    while j < len(arr1) and l < len(arr2):
        if arr1[j] <= arr2[l]:
            arr[i] = arr1[j]
            j += 1
        else:
            arr[i] = arr2[l]
            l += 1
        i += 1

    while j < len(arr1):
        arr[i] = arr1[j]
        j += 1
        i += 1

    while l < len(arr2):
        arr[i] = arr2[l]
        l += 1
        i += 1


def copy_lists(arr, arr1, arr2, left, right, mid):
    # copy array1
    for i in range(left, mid + 1):
        arr1.append(arr[i])

    # copy array2
    for i in range(mid + 1, right + 1):
        arr2.append(arr[i])

arr = [8,7,5,1,3,4]
arr = [38, 27, 43, 3, 9, 82, 10]
merge_sort(arr)
print("arr: {}", arr)

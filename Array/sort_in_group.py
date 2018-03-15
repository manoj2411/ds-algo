def sort_in_group(arr, k):
    left = 0
    right = left + k - 1
    n = len(arr)
    while right < n :
        qsort(arr, left, right)
        left = right + 1
        right = left + k - 1
    qsort(arr, left, n - 1)

def qsort(arr, left, right):
    if right > left :
        pivot_indx = partition(arr, left, right)
        qsort(arr, left, pivot_indx - 1)
        qsort(arr, pivot_indx + 1, right)

def partition(arr, left, right) :
    pivot = arr[right]
    mid = i = left
    while i < right :
        if arr[i] < pivot :
            arr[mid], arr[i] = arr[i], arr[mid]
            mid += 1

        i += 1
    arr[mid], arr[right] = arr[right], arr[mid]
    return mid

arr = [10, 80, 30, 90, 50, 40, 70]
print("Arr: {}".format(arr))
sort_in_group(arr, 4)
print("Group sorted: {}".format(arr))

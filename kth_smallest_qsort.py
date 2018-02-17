import random

def find_smallest_k(arr, k):
    return qsort_util(arr, 0, len(arr) - 1, k - 1)

def qsort_util(arr, left, right, k):
    if left <= right:
        pivot = partition(arr, left, right)
        if pivot == k:
            return arr[pivot]
        elif pivot < k:
            return qsort_util(arr, pivot + 1, right, k)
        else:
            return qsort_util(arr, left, pivot - 1, k)

def partition(arr, left, right):
    mid = i = left
    pivot = random.randint(left,right)
    # randomize quick sort partition
    arr[pivot], arr[right] = arr[right], arr[pivot]
    pivot = arr[right]
    while i < right:
        if arr[i] >= pivot:
            i += 1
        else:
            arr[mid], arr[i] = arr[i], arr[mid]
            i += 1
            mid += 1

    arr[mid], arr[right] = arr[right], arr[mid]

    return mid

# arr = [7,10,4,3,20,15]
arr = [7,10,4,20,15]
print(find_smallest_k(arr, 4))

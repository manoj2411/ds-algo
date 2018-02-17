def qsort(arr, left, right):
    if left <= right:
        pivot_indx = partition(arr, left, right)

        qsort(arr, left, pivot_indx - 1)
        qsort(arr, pivot_indx + 1, right)

def partition(arr, left, right):
    pivot = arr[right]
    i = mid = left
    # print("IN: {} piv: {} l: {} r: {}".format( arr, pivot, left, right))
    while i < right:
        if arr[i] > pivot:
            i += 1
        else:
            swap(arr, mid, i)
            mid += 1
            i += 1

    # place pivot element
    swap(arr, mid, right)
    # print("OUT: {} mid: {}".format(arr, mid ))
    # print('')
    return mid

def swap(arr, i, j):
    arr[i], arr[j] = arr[j], arr[i]


# lst = [7,10,4,3,20,15]
# lst = [10, 80, 30, 90, 50, 40, 70]
lst = [10, 7, 8, 9, 1, 5]

print("Original: {}".format(lst))

qsort(lst, 0, len(lst) - 1)

print("Sorted: {}".format(lst))

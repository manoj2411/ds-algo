def msort(arr):
    msort_util(arr, 0, len(arr) - 1)

def msort_util(arr, left, right):
    if left == right :
        return

    if left < right:
        mid1, mid2 = partition(arr, left, right)

        msort_util(arr, left, mid1 - 1)
        msort_util(arr, mid2 + 1, right)

def partition(arr, left, right):
    mid = left
    piv = arr[right]

    while mid <= right:
        if arr[mid] == piv:
            mid += 1
            # continue
        elif arr[mid] < piv:
            # switch and incr mid and left.
            arr[left], arr[mid] = arr[mid], arr[left]
            mid += 1
            left += 1
        else:
            # switch mid & right and decrement right
            arr[right], arr[mid] = arr[mid], arr[right]
            right -= 1

    return left, right

# sample cases:

arr = [6,3,4,2,2,1,3,6,3,2]
print("List: {}".format(arr))
msort(arr)
print("Sorted: {}".format(arr))

arr = [1, 4, 2, 5,4, 2,3, 4, 1, 2,4, 1, 2, 2, 2, 2, 4, 1, 4, 4, 4]
print("\nList: {}".format(arr))
msort(arr)
print("Sorted: {}".format(arr))

arr = [10, 6, 12, 1, 4, 2, 3]
print("\nList: {}".format(arr))
msort(arr)
print("Sorted: {}".format(arr))

arr = [4, 9, 4, 4, 1, 9, 4, 4, 9, 4, 4, 1, 4]
print("\nList: {}".format(arr))
msort(arr)
print("Sorted: {}".format(arr))

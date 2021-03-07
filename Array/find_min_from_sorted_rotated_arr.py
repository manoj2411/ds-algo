def find_min(arr):
    left = 0
    right = len(arr) - 1

    while left <= right:
        mid = left + ((right - left) / 2)
        if arr[mid] <= arr[right]:
            if mid == 0 or arr[mid - 1] > arr[mid]:
                return arr[mid]
            # reset right
            right = mid - 1
        else:
            left = mid + 1

arr = [5, 6, 1, 22, 33, 44]
print(find_min(arr))

arr = [2, 6, 0, 1]
print(find_min(arr))

arr = [0, 1, 4, 5]
print(find_min(arr))

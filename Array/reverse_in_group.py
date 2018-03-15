def reverse_in_group(arr, k):
    left = 0
    right = left + k - 1
    n = len(arr)
    while right < n:
        reverse(arr, left, right)
        left = right + 1
        right = left + k - 1
    reverse(arr, left, n - 1)

def reverse(arr, left, right):
    while left < right :
        arr[left], arr[right] = arr[right], arr[left]
        left += 1
        right -= 1

arr = [1,2,3,4,5,6,7,8]
print("Arr: {}".format(arr))
reverse_in_group(arr, 3)
print("New arr: {}".format(arr))

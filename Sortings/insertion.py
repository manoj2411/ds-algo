def insertion_sort(arr):
    for i in range(len(arr)):
        if arr[i - 1] > arr[i]:
            do_shifting(arr, i)

def do_shifting(arr, i):
    while i > 0 and arr[i - 1] > arr[i] :
        arr[i - 1], arr[i] = arr[i], arr[i - 1]
        i -= 1


for arr in [[2,4,3,9,5,6,1,7], [12, 11, 13, 5, 6]]:
    print("Arr: {}".format(arr))
    insertion_sort(arr)
    print("Sorted: {}\n".format(arr))

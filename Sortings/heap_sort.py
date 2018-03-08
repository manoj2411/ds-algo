def hsort(arr):
    # rearrange: heapify array
    heapify_list(arr)
    #
    # replace root with last element and heapify list by reducing size by 1
    for i in range(len(arr) - 1, -1, -1):
        arr[i], arr[0] = arr[0], arr[i]
        heapify(arr, 0, i)

def heapify_list(arr):
    length = len(arr)
    parent_of_last_leaf = parent(length - 1)
    for i in range(parent_of_last_leaf, -1, -1):
        heapify(arr, i, length)

def heapify(arr, i, length):
    largest = i
    left_child = (i * 2) + 1
    right_child = (i * 2) + 2

    if left_child < length and arr[left_child] > arr[largest] :
        largest = left_child

    if right_child < length and arr[right_child] > arr[largest] :
        largest = right_child

    if largest != i:
        arr[largest], arr[i] = arr[i], arr[largest]
        heapify(arr, largest, length)

def parent(i):
    return (i - 1) / 2

arr = [12, 11, 13, 5, 6, 7]

print("Arr: {}".format(arr))
hsort(arr)
print("Sorted: {}".format(arr))

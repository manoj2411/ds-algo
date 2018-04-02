def print_deplicates(arr):
  high = len(arr)
  for i in range(high):
    ele = arr[i] % high
    arr[ele] += high
  print("Arr: {}".format(arr))

  for i in range(high):
    ele = arr[i] % high
    if arr[ele] >= high * 2 :
      print(ele, end = ' ')
    arr[ele] = arr[ele] % high
  print()

arr = [1, 6, 3, 1, 2, 3, 6, 3]
arr = [1, 3, 3, 1, 1, 1, 3, 6, 6, 0,2]

print("Arr: {}".format(arr))
print_deplicates(arr)

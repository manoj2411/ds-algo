def stock_by_sell(arr):
    if len(arr) <= 1 :
        return

    end = start = 0
    for i in range(1, len(arr)):
        if arr[i] > arr[end] :
            end = i
        else :
            if start != end :
                print("({},{}) -- ({},{})".format(start, end, arr[start], arr[end]))
            start = end = i

    if start != end :
        print("({},{}) -- ({},{})".format(start, end, arr[start], arr[end]))

    # i = 0
    # length = len(arr)
    # while i < length - 1:
    #     while i < length - 1 and arr[i] > arr[i + 1] :
    #         i += 1

    #     if i == length - 1 :
    #         break

    #     start = i

    #     while i < (length - 1) and arr[i] < arr[i + 1]:
    #         i += 1

    #     print("({},{}) -- ({},{})".format(start, i, arr[start], arr[i]))
    #     i += 1


lists = [[100,180,260,310,40,535,695], [23,13,25,29,33,19,34,45,65,67],
         [10,9,8,6,10,20,12,22]]

for lst in lists :
    print("List: {}".format(lst))
    stock_by_sell(lst)
    print("\n")



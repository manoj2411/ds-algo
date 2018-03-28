def stock_by_sell(arr):
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

lists = [[100,180,260,310,40,535,695], [23,13,25,29,33,19,34,45,65,67]]

for lst in lists :
    print("List: {}".format(lst))
    stock_by_sell(lst)
    print("\n")



def tsearch(lst, low, high, key):
    #Code here
    low = 0
    high = len(lst) - 1
    mid1 = int((low + high) / 3)
    mid2 = int(2 * (low + high) / 3)

    while low >= 0 and high < (len(lst)) and mid1 >= low and mid2 <= high and low <= high:
        # print(['low', low, 'mid1', mid1, 'mid2', mid2, 'high', high])
        if lst[mid1] == key:
            return mid1
        elif lst[mid2] == key:
            return mid2
        elif key >= lst[low] and key < lst[mid1]:
            high = mid1 - 1
        elif key > lst[mid1] and key < lst[mid2]:
            low = mid1 + 1
            high = mid2 - 1
        elif key > lst[mid2] and key <= lst[high]:
            low = mid2 + 1
        else:
            return -1
        mid1 = int((low + high) / 3) if int((low + high) / 3) > low else low
        mid2 = int(2 * (low + high) / 3)
        # print(['low', low, 'mid1', mid1, 'mid2', mid2, 'high', high])

    return -1



if __name__ == '__main__' :
    print (tsearch([11,22,33,44,55],0,0, 1))
    print (tsearch([11,22,33,44,55],0,0,56))
    print (tsearch([11,22,33,44,55],0,0, 20))
    print (tsearch([11,22,33,44,55],0,0, 11))
    print (tsearch([11,22,33,44,55],0,0, 22))
    print (tsearch([11,22,33,44,55],0,0, 44))
    print (tsearch([11,22,33,44,55],0,0, 55))
    print (tsearch([11,22,33,44,55],0,0, 33))
    print (tsearch([11,22,33,44,55],0,0, 45))
    print (tsearch([11,22,33,44,55],0,0, 145))
    print (tsearch([11,22,33,44,55],0,0, 14))
    print (tsearch([11,22,33,44,55],0,0, 24))
    print (tsearch([11,22,33,44,55],0,0, 35))

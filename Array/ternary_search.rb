def tsearch(lst, low, high, key):
    #Code here
    if high >= low :
        mid1 = low + int((high - low) / 3)
        mid2 = mid1 + int((high - low) / 3)

        # print(['low', low, 'mid1', mid1, 'mid2', mid2, 'high', high])
        if lst[mid1] == key :
            return mid1
        elif lst[mid2] == key :
            return mid2
        elif key < lst[mid1] :
            return tsearch(lst, low, mid1 - 1, key)
        elif key < lst[mid2] :
            return tsearch(lst, mid1 + 1, mid2 - 1, key)
        return tsearch(lst, mid2 + 1, high, key)
    return -1


if __name__ == '__main__' :
    print (tsearch([11,22,33,44,55],0,4, 1))
    print (tsearch([11,22,33,44,55],0,4,56))
    print (tsearch([11,22,33,44,55],0,4, 20))
    print (tsearch([11,22,33,44,55],0,4, 11))
    print (tsearch([11,22,33,44,55],0,4, 22))
    print (tsearch([11,22,33,44,55],0,4, 44))
    print (tsearch([11,22,33,44,55],0,4, 55))
    print (tsearch([11,22,33,44,55],0,4, 33))
    print (tsearch([11,22,33,44,55],0,4, 45))
    print (tsearch([11,22,33,44,55],0,4, 145))
    print (tsearch([11,22,33,44,55],0,4, 14))
    print (tsearch([11,22,33,44,55],0,4, 24))
    print (tsearch([11,22,33,44,55],0,4, 35))

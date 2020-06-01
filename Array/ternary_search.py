def tsearch(lst, low, high, key):
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
    print (tsearch([11,22,33,44,55],0,4, 11)) # 0
    print (tsearch([11,22,33,44,55],0,4, 22)) # 1
    print (tsearch([11,22,33,44,55],0,4, 33)) # 2
    print (tsearch([11,22,33,44,55],0,4, 44)) # 3
    print (tsearch([11,22,33,44,55],0,4, 55)) # 4
    print (tsearch([11,22,33,44,55],0,4, 1)) # -1
    print (tsearch([11,22,33,44,55],0,4,56)) # -1
    print (tsearch([11,22,33,44,55],0,4, 20)) # -1
    print (tsearch([11,22,33,44,55],0,4, 45)) # -1
    print (tsearch([11,22,33,44,55],0,4, 145)) # -1
    print (tsearch([11,22,33,44,55],0,4, 14)) # -1
    print (tsearch([11,22,33,44,55],0,4, 24)) # -1
    print (tsearch([11,22,33,44,55],0,4, 35)) # -1
    print (tsearch([2,6,8,9,12,13,15,24],0,7, 9)) # -1

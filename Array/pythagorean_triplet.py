def has_pythagorean_triplet(arr) :
    squard_lst = map(lambda x: x * x, arr)
    squard_lst.sort()

    for i in range(len(squard_lst) - 1, 1, -1):
        low = 0
        high =  i - 1
        while low < high :
            _sum = squard_lst[low] + squard_lst[high]
            if _sum == squard_lst[i] :
                print("Result found ({}, {}, {})".format(squard_lst[low], squard_lst[high], squard_lst[i]))
                return True
            elif _sum > squard_lst[i] :
                high -= 1
            else :
                low += 1
    return False

arr = [3,2,4,6,5]
print("Arr: {}".format(arr))
print(has_pythagorean_triplet(arr))

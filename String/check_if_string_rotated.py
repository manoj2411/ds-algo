def is_rotated_string(original, new, k = 2):
    length = len(new)
    if length != len(original):
        return false
    flag = True

    # check anti-clockwise
    for i in range(0, length) :
        rotated_indx = (i + k) % length
        if original[rotated_indx] != new[i] :
            flag = False
            break

    if flag == True :
        return flag

    for i in range(0, length) :
        rotated_indx = (i + (length - k)) % length
        if original[rotated_indx] != new[i] :
            return False

    return True

lists = [['amazon', 'azonam'], ['amazon', 'onamaz'], ['geeksforgeeks', 'geeksgeeksfor']]

for arr in lists :
    print("String1: {}\nString2: {}".format(arr[0], arr[1]))
    print(is_rotated_string(arr[0], arr[1]))
    print()



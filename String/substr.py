def strstr(s, x):
    for i in range(len(s)) :
        if s[i] == x[0] :
            if i + len(x) > len(s) :
                return -1
            k = i + 1
            for j in range(1, len(x)) :
                if s[k] == x[j] :
                    k += 1
                    next
                else:
                    k = i
                    break
            if k != i :
                return i

arr = ['abaaabab', 'abb']
print("Str: {} \t {}".format(arr, strstr(*arr)))



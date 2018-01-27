def max_stolen(lst, n):
    if n == 0:
        return 0
    elif n == 1:
        lst[1]
    elif n == 2:
        max(lst)

    # res = [0] * n
    # res[0] = lst[0]
    # res[1] = max(lst[0], lst[1])
    val2 = lst[0]
    val1 = max(lst[0], lst[1])
    for i in range(2,n):
        curr = max(lst[i] + val2, val1)
        val2 = val1
        val1 = curr

    return val1

def main():
    lst = [6,7,1,3,8,2,4]
    # lst = [5,3,4,11,2]
    n = len(lst)
    print("Max value stolen is: " + str(max_stolen(lst, n)) )

if __name__ == '__main__':
    main()

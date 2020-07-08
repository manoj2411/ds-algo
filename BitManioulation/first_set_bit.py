def findFirstSetBit(num):

    position = 1
    while num != 0:
        if num & 1 == 1 :
            return position
        num >>= 1
        position += 1

    return 0



if __name__ == '__main__':
    print("how many test case?", end = " ")
    testCases = int(input())

    for i in range(testCases):
        num = int(input())
        print(findFirstSetBit(num))


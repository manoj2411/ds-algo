# Assuming matrix is a valid NxN matrix of integers
def traverse_spirally(matrix):
    low = 0
    high = len(matrix) - 1
    while low < high :
        # move towards right
        for i in range(low, high) :
            print(matrix[low][i], end = ' ')

        # move towards down
        for i in range(low, high) :
            print(matrix[i][high], end = ' ')

        # move towards left
        for i in range(high, low, -1):
            print(matrix[high][i], end = ' ')

        # move towards up
        for i in range(high, low, -1):
            print(matrix[i][low], end = ' ')

        # reset low and high
        low += 1
        high -= 1

    if low == high :
        print(matrix[high][high])
    print()

matrix = [
    [1,2,3,4],
    [5,6,7,8],
    [9,10,11,12],
    [13,14,15,16]
]

matrix = [
    [1,2,3],
    [4,5,6],
    [7,8,9]
]

matrix = [
    [1,2,3,4,5],
    [6,7,8,9,10],
    [11,12,13,14,15],
    [16,17,18,19,20],
    [21,22,23,24,25]

]

traverse_spirally(matrix)

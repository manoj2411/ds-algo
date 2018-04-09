def traverse_spirally(matrix):
    rowl = coll = 0
    rowh = len(matrix) - 1
    colh = len(matrix[0]) - 1

    while rowl <= rowh and coll <= colh:
        # 1 - left to right
        if rowl <= rowh:
            for i in range(coll, colh + 1) :
                print(matrix[rowl][i], end = ' ')
            rowl += 1
        # 2 - top to down
        if coll <= colh :
            for i in range(rowl, rowh + 1):
                print(matrix[i][colh], end = ' ')
            colh -= 1
        # 3 - right to left
        if rowl <= rowh :
            for i in range(colh, coll - 1, -1):
                print(matrix[rowh][i], end = ' ')
            rowh -= 1
        # 4 - bottom to top
        if coll <= colh :
            for i in range(rowh, rowl - 1, -1) :
                print(matrix[i][coll], end = ' ')
            coll += 1
    print('')




matrix = [
    [1,2,3,4],
    [5,6,7,8],
    [9,10,11,12],
    [13,14,15,16]
]

print("Matrix 1")
traverse_spirally(matrix)

matrix = [
    [1,2,3,4,5,6],
    [7,8,9,10,11,12],
    [13,14,15,16,17,18]
]
print("\nMatrix 2")
traverse_spirally(matrix)

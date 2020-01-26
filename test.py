# A Dynamic Programming based Python Program for 0-1 Knapsack problem
# Returns the maximum value that can be put in a knapsack of capacity W
def knapSack(W, wt, val, n):
    K = [[0 for x in range(W+1)] for x in range(n+1)]

    # Build table K[][] in bottom up manner
    for i in range(n+1):
        for w in range(W+1):
            if i==0 or w==0:
                K[i][w] = 0
            elif wt[i-1] <= w:
                K[i][w] = max(val[i-1] + K[i-1][w-wt[i-1]], K[i-1][w])
            else:
                K[i][w] = K[i-1][w]

    print("Matrix: ")
    for row in K :
        print(row)
    print("")

    return K[n][W]

# Driver program to test above function
val = [60, 100, 120]
wt = [10, 20, 30]
W = 50
n = len(val)
print(knapSack(W, wt, val, n))

























# def stock(arr):
#     n = len(arr)
#     buy_at = -1
#     for i in range(n):
#         if buy_at < 0:
#             if i + 1 < n and arr[i + 1] > arr[i]:
#                 buy_at = i
#         elif i + 1 < n and arr[i] > arr[i + 1]:
#             print("({}, {})".format(buy_at, i))
#             buy_at = -1

#     if buy_at >= 0:
#         print("({}, {})".format(buy_at, n - 1))

# lst = [[100,180,260,310,40,535,695], [23,13,25,29,33,19,34,45,65,67]]

# for arr in lst:
#     print("Arr: {}".format(arr))
#     stock(arr)
#     print()



# def m1(s1):
#     cl = ml = 0
#     hs = {}
#     for i in range(len(s1)):
#         if (s1[i] not in hs) or i - cl > hs[s1[i]]:
#             cl += 1
#         else:
#             if ml < cl:
#                 ml = cl
#             cl = i - hs[s1[i]]

#         hs[s1[i]] = i
#     if ml < cl:
#         ml = cl
#     return ml

# lst = ['ABDEFGABEF', 'GEEKSFORGEEKS', 'BBBBBB']
# for st in lst:
#     print("Arr: {}\n{}\n\n".format(st, m1(st)))


# print( l)
# ['000', '001', '010', '011', '100', '101', '110', '111']

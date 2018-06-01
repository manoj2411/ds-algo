def knapsack(weight, arr_w, arr_v, n):
    if n == -1 or weight == 0:
        return 0
    elif arr_w[n] > weight :
        return knapsack(weight, arr_w, arr_v, n - 1)
    else :
        return max(knapsack(weight - arr_w[n], arr_w, arr_v, n - 1) + arr_v[n],
                    knapsack(weight, arr_w, arr_v, n - 1))

val = [60, 100, 120]
wt = [10, 20, 30]
weight = 50


print(knapsack(weight, wt, val, len(val) - 1))

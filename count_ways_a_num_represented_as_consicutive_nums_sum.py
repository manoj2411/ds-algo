# Count ways to express a number as sum of consecutive numbers

def representations_count(num):
    count = 0
    low = 1
    high = 2
    _sum = low + high
    # lp = 0
    while high <= (num / 2) + 1 :
        # lp += 1
        if _sum == num :
            count += 1
            high += 1
            _sum += high
            _sum -= low
            low += 1
            continue
        if num > _sum :
            high += 1
            _sum += high
        else:
            _sum -= low
            low += 1
    # print("lp: {}".format(lp))
    return count

inputs = [150, 10, 14, 9]

for inp in inputs:
    print("Input: {}".format(inp))
    print("Output: {}\n".format(representations_count(inp)))

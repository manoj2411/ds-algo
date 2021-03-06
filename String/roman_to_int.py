def roman_to_int(str):
    mapping = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

    number = 0
    prev = 0

    for i in range(len(str) - 1, -1, -1):
        curr = mapping[str[i]]

        if curr < prev :
            number -= curr
        else:
            number += curr
        prev = curr

    return number


arr = ['IX', 'XL', 'MCMIV', 'XCIX']
for roman in arr:
    print("Roman: {}".format(roman))
    print("Number: {}\n".format(roman_to_int(roman)))


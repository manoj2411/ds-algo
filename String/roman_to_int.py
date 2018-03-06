def roman_to_int(roman_str):
    hs = {'I': 1, 'V': 5, 'X': 10, 'L': 50, 'C': 100, 'D': 500, 'M': 1000}

    length = len(roman_str)
    number = 0
    prev = None
    for i in range(0, length):
        number += hs[roman_str[i]]
        if (prev is not None) and (hs[prev] < hs[roman_str[i]]) :
            number -= hs[prev] * 2
        prev = roman_str[i]
    return number


arr = ['IX', 'XL', 'MCMIV']
for roman in arr:
    print("Roman: {}".format(roman))
    print("Number: {}\n".format(roman_to_int(roman)))


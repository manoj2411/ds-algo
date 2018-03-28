def remove_deplicates(string) :
    hsh = {}

    for char in string :
        if char not in hsh:
            print(char, end = '')
            hsh[char] = True

lst = ['geeksforgeeks', 'geeks for geeks']
for string in lst :
    print(string)
    remove_deplicates(string)
    print("\n")



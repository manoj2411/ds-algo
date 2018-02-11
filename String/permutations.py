def permute_helper(string, choosen):
    if not string:
        print(choosen)
    else:
        for i in range(len(string)):
            # choose
            chr = string[i]
            string = string[:i] + string[i + 1:]
            choosen += chr
            # explore
            permute_helper(string, choosen)

            # un-choose
            string = string[:i] + chr + string[i:]
            choosen = choosen[:-1]

def permute(string):
    permute_helper(string, '')


permute("AB")

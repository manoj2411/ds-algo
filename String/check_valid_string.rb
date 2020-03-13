# Valid Parenthesis String
# string has 3 types of characters: `(`, `)` and `*`. `*` can be treated as `(` or `)` or empty string

def check_valid_string(s)
    open_parentheses = []
    asterisks = []

    for i in 0..(s.length - 1)
        chr = s[i]

        if chr == '('
            open_parentheses << i
        elsif chr == '*'
            asterisks << i
        else
            return false if open_parentheses.empty? && asterisks.empty?

            if !open_parentheses.empty?
                open_parentheses.pop
            else
                asterisks.pop
            end
        end
    end

    while !open_parentheses.empty? && !asterisks.empty?
        return false if asterisks.pop < open_parentheses.pop
    end

    open_parentheses.empty?
end


for str in [
    "()", # true
    "(*)", # true
    "(*))", # true
    "(((*)*", # true
    "(((**", # false
    "***)(((*)", # false
    "(***)(((*)", # false
    "(())((())()()(*)(*()(())())())()()((()())((()))(*", # false
]

    # puts "Input: #{str}"
    puts "Res: #{check_valid_string str}"
end

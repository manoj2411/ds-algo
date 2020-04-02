# parenthesis-checker
CLOSINGS = {
    ']' => '[',
    '}' => '{',
    ')' => '('
}
def parenthesis_checker(str)
    stack = []
    str.each_char do |chr|
        if CLOSINGS[chr]
            return false  if stack.empty? || stack.pop != CLOSINGS[chr]
        else
            stack.push(chr)
        end
    end
    stack.empty?
end

for str in [
    '{([])}', # true
    '()', # true
    '([]', # false
    '[()]{}{[()()]()}', # true
    '[(])', # false
]
    puts "balanced? #{"%20.20s" % str} : #{parenthesis_checker(str)}"
end

# Balanced parenthesis
# Create function that will determine are the parenthesis balanced in a given string

# a(bcd)d => true
# (kjds(hfkj)sdhf => false
# (sfdsf)(fsfsf => false
# {[]}() => true
# {[}] => false

def is_balanced?(str)
  stack = []

  str.each_char do |chr|
    if chr == '(' || chr == '{' || chr == '['
      stack.push(chr)
      next
    end

    if chr == ']' && stack.pop != '['
      return false
    elsif chr == '}' && stack.pop != '{'
      return false
    elsif chr == ')' && stack.pop != '('
      return false
    end
  end

  stack.empty?
end


for str in [
  "a(bcd)d", # true
  "(kjds(hfkj)sdhf", # false
  "(sfdsf)(fsfsf", # false
  "{[]}()", # true
  "{[}]", # false
]

  puts "is_balanced? #{is_balanced?(str)} \t #{str} "
end

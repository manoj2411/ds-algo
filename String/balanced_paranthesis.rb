# Balanced parenthesis
# Create function that will determine are the parenthesis balanced in a given string

# a(bcd)d => true
# (kjds(hfkj)sdhf => false
# (sfdsf)(fsfsf => false
# {[]}() => true
# {[}] => false

def is_balanced?(str)
  stack = []
  open_parns = ['[', '(', '{']
  closing_parns = [']', ')', '}']

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
  return stack.empty?
end

# str = "a(bcd)d"
# str = "(kjds(hfkj)sdhf"
# str = "(sfdsf)(fsfsf"
# str = "{[]}()"
# str = "{[}]"

puts "String: #{str} \nis_balanced? #{is_balanced?(str)}"

OPERATORS = %w{+ - / * ^}

def evaluate_postfix_expression(str)
  stack = []

  str.split(' ').each do |token|
    if OPERATORS.include?(token)
        operand2 = stack.pop
        operand1 = stack.pop
        result = token == "^" ? (operand1 ** operand2) : operand1.send(token, operand2)
        stack.push result
    else
        stack.push token.to_i
    end
  end

  stack.pop
end

for exp in [
    "2 3 1 * + 9 -", # -4
    '1 2 3 + * 8 -', # -3
    '100 200 + 2 / 5 * 7 +', # 757
]
    puts "Expression: #{exp}"
    puts "#{evaluate_postfix_expression(exp)}"
end

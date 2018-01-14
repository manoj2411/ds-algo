OPERATORS = %w{+ - / * ^}
def evaluate_postfix_expression(str)
  stack = []

  str.each_char do |char|
    if OPERATORS.include?(char)
      operand2 = stack.pop
      operand1 = stack.pop
      result = if char == "^"
                  operand1 ** operand2
                else
                  operand1.send(char, operand2)
                end
      stack.push result
    else
      stack.push char.to_i
    end
  end
  return stack.pop
end

str = "231*+9-"
puts evaluate_postfix_expression(str)

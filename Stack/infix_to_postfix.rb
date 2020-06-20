OPERATORS = {
  "^" => 3,
  "/" => 2,
  "*" => 2,
  "+" => 1,
  "-" => 1,
  "(" => 0
}


def convert_infix_to_postfix(str)
  stack = []
  res = []
  str.each_char do |chr|

    if chr == "("
      stack.push(chr)
    elsif chr == ")"
      while stack.last != "("
        res << stack.pop
      end
      stack.pop
    elsif OPERATORS.key?(chr)
      # push to stack
      while !stack.empty? && OPERATORS[stack.last] >= OPERATORS[chr]
        res << stack.pop
      end
      stack.push(chr)
    else
      res << chr
    end
  end

  while !stack.empty?
    res << stack.pop
  end
  res.join
end


str = "a+b*c"
puts convert_infix_to_postfix(str)

puts convert_infix_to_postfix('A*(B+C)/D')

str = "a+b*(c^d-e)^(f+g*h)-i"
puts convert_infix_to_postfix(str)


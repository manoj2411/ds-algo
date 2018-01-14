require "pry"

PRECIDENCE ={
  "^" => 3,
  "/" => 2,
  "*" => 2,
  "+" => 1,
  "-" => 1,
  "(" => 0
}

OPERATORS = PRECIDENCE.keys
def convert_infix_to_postfix(str)
  stack = []

  str.each_char do |chr|
    if chr == "("
      stack.push(chr)
    elsif chr == ")"
      while stack.last != "("
        print stack.pop
      end
      stack.pop
    elsif OPERATORS.find {|e| e == chr}
      # push to stack
      while !stack.empty? && PRECIDENCE[stack.last] >= PRECIDENCE[chr]
        print stack.pop
      end
      stack.push(chr)
    else
      print chr
    end
  end

  while !stack.empty?
    print stack.pop
  end
end

str = "a+b*c"
str = "a+b*(c^d-e)^(f+g*h)-i"
convert_infix_to_postfix(str)

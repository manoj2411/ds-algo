import java.util.*;
/*
        https://leetcode.com/problems/basic-calculator-ii/
*/
class BasicCalculatorII {
    public static void main(String[] args) {
        String[] input = {
            "3+2*2", // 7
            " 3/2 ", // 1
            " 3+5 / 2 ", // 5
            "3 * 7 / 2" , // 10
        };
        for(String expression : input) {
            Solution sol = new Solution();
            System.out.println(expression + " ==>> " + sol.calculate(expression));
        }
    }
}

class Solution {

    public int calculate(String s) {
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        Map<Character, Byte> precedence = getPrecedence();

        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i);

            if(ch == ' ') {
                i++;
            } else if(precedence.containsKey(ch)) {
                // System.out.println(ch);
                while(!operators.isEmpty() && precedence.get(operators.peek()) >= precedence.get(ch) ) {
                    int result = eval(operators.pop(), operands.pop(), operands.pop());
                    operands.push(result);
                }
                operators.push(ch);
                i++;
            } else {
                String numStr = nextInt(s, i);
                // System.out.println(numStr);
                operands.push(new Integer(numStr));
                i += numStr.length();
            }
        }

        while(!operators.isEmpty()) {
            int result = eval(operators.pop(), operands.pop(), operands.pop());
            operands.push(result);
        }

        return operands.pop();
    }

    private int eval(char operator, int op2, int op1) {
        if(operator == '+') return op1 + op2;
        else if(operator == '-') return op1 - op2;
        else if(operator == '/') return op1 / op2;
        else return op1 * op2;
    }

    private String nextInt(String s, int i) {
        StringBuilder sb = new StringBuilder();
        while(i < s.length() && Character.isDigit(s.charAt(i)) ) {
            sb.append(s.charAt(i++));
        }
        return sb.toString();
    }

    private Map<Character, Byte> getPrecedence() {
        Map<Character, Byte> precedence = new HashMap<>();
        precedence.put('-', (byte) 1);
        precedence.put('+', (byte) 1);
        precedence.put('/', (byte) 2);
        precedence.put('*', (byte) 2);
        return precedence;
    }
}

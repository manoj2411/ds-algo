import java.util.*;

/*
	https://leetcode.com/problems/evaluate-reverse-polish-notation/
*/
class EvaluateReversePolishNotation {
	public static void main(String[] args) {
		String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};`
		System.out.println(new Solution().evalRPN(tokens)); // 22
	}
}


class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("-")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 - op2);
            } else if (token.equals("/")) {
                int op2 = stack.pop();
                int op1 = stack.pop();
                stack.push(op1 / op2);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}

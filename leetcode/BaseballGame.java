import java.util.*;

/*
	https://leetcode.com/problems/baseball-game/
*/
class BaseballGame {
	public static void main(String[] args) {
		String[] ops = {"5","2","C","D","+"};
		System.out.println(new Solution().calPoints(ops)); // 30

		ops = new String[] {"5","-2","4","C","D","9","+","+"};
		System.out.println(new Solution().calPoints(ops)); // 27
	}
}

class Solution {
    public int calPoints(String[] ops) {

        Stack<Integer> stack = new Stack<>();

        for(String op : ops) {
            if (op.equals("C")) {
                stack.pop();
            } else if (op.equals("D")) {
                int num = stack.peek();
                stack.push(num * 2);
            } else if (op.equals("+")) {
                int num1 = stack.pop();
                int num2 = stack.pop();

                stack.push(num2);
                stack.push(num1);
                stack.push(num2 + num1);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }

        int result = 0;

        for(int num : stack) {
            result += num;
        }
        return result;
    }
}

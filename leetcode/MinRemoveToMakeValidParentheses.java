import java.util.*;

/*
    https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
*/
class MinRemoveToMakeValidParentheses {
	public static void main(String[] args) {
		String[] inputs = {"lee(t(c)o)de)", "a)b(c)d", "))((", "(a(b(c)d)"};

		for(String str : inputs) {
			System.out.println("S: " + str);
			System.out.println("Valid S: '" + new Solution().minRemoveToMakeValid(str) +"'");
			System.out.println();
		}
	}
}

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> toRemove = new Stack();


        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') stack.push(i);
            else if(ch == ')') {

                if(stack.isEmpty()) toRemove.push(i);
                else stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder(s);

        while(stack.size() > 0) sb.deleteCharAt(stack.pop());

        while(toRemove.size() > 0) sb.deleteCharAt(toRemove.pop());

        return sb.toString();
    }
}

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
        Set<Integer> toRemove = new HashSet<>();


        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') stack.push(i);
            else if(ch == ')') {

                if(stack.isEmpty()) toRemove.add(i);
                else stack.pop();
            }
        }

        while(stack.size() > 0) toRemove.add(stack.pop());

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < s.length(); i++) {
            if(!toRemove.contains(i)) sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}

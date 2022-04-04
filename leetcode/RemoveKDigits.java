import java.util.*;

/*
	https://leetcode.com/problems/remove-k-digits/
*/
class RemoveKDigits {
	public static void main(String[] args) {
		System.out.println(new Solution().removeKdigits("1432219", 3)); // "1219"
		System.out.println(new Solution().removeKdigits("10", 2)); // "0"
		System.out.println(new Solution().removeKdigits("10200", 1)); // "200"
		System.out.println(new Solution().removeKdigits("10200", 2)); // "0"
		System.out.println(new Solution().removeKdigits("1234567890", 9)); // "0"
		System.out.println(new Solution().removeKdigits("5337", 2)); // "33"

	}
}


class Solution {
	/*
		Complexity
			time: 	O(N)
			Space:	O(N)

		Idea is to keep numbers in stack in non-decreasing order until k > 0
			if stack peek is greater then current char the keep popping elements.
	*/


    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for(char ch : num.toCharArray()) {
            while(stack.size() > 0 && stack.peek() > ch && k > 0) {
                stack.pop();
                k--;
            }
            stack.add(ch);
        }

        // remove K items from stack
        for(int i = 0; i < k; i++)
            stack.pop();

        // build result from stack
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty())
            sb.append(stack.pop());

        // Remove leading 0's from result
        for(int i = sb.length() - 1; i > 0; i--)
            if (sb.charAt(i) == '0') sb.setLength(i);
            else break;

        // since the character were in stack, the result is in reverse order
        sb.reverse();

        return sb.isEmpty() ? "0" : sb.toString();
    }
}

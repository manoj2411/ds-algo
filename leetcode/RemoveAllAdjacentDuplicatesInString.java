import java.util.*;

/*
	https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
*/
class RemoveAllAdjacentDuplicatesInString {
	public static void main(String[] args) {

		System.out.println(new Solution().removeDuplicates("abbaca")); // "ca"
		System.out.println(new Solution().removeDuplicates("azxxzy")); // "ay"
	}
}

class Solution {
    public String removeDuplicates(String s) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else if (s.charAt(stack.peek()) == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i : stack)
            sb.append(s.charAt(i));

        return sb.toString();
    }
}

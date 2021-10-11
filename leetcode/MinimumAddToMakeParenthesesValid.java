/*
	https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/
*/
class MinimumAddToMakeParenthesesValid {
	public static void main(String[] args) {

		System.out.println(new Solution().minAddToMakeValid("())")); // 1
		System.out.println(new Solution().minAddToMakeValid("(((")); // 3
		System.out.println(new Solution().minAddToMakeValid("()")); // 0
		System.out.println(new Solution().minAddToMakeValid("()))((")); // 4
	}
}

class Solution {

    public int minAddToMakeValid(String s) {
        int openCount = 0;
        int closeCount = 0;

        for(char ch : s.toCharArray()) {
            if (ch == '(') { // open
                openCount++;
            } else { // close
                if (openCount > 0) openCount--;
                else closeCount++;
            }
        }

        return openCount + closeCount;
    }

}

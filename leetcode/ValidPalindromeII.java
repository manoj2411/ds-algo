/*
	https://leetcode.com/problems/valid-palindrome-ii/
*/
class ValidPalindromeII {
	public static void main(String[] args) {
		String[] input = { "aba", "abca", "abc"};
		for(String str : input) {
			System.out.println("String: " + str + "\n" +
				"valid palindorme by ignoring at most one character: " +
				new Solution().validPalindrome(str) + "\n");
		}
	}
}

class Solution {
    public boolean validPalindrome(String s) {
        return isPalindromeUtil(s, 0, s.length() - 1, false);
    }

    boolean isPalindromeUtil(String s, int left, int right, boolean ignoredOnce) {

        while(left < right) {

            if(s.charAt(left) != s.charAt(right)) {

                if(ignoredOnce) {
                    return false;
                } else {
                    return isPalindromeUtil(s, left, right - 1, true) ||
                    isPalindromeUtil(s, left + 1, right, true);
                }

            }

            left++;
            right--;
        }

        return true;
    }
}

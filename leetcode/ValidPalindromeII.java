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

    boolean isPalindromeUtil(String s, int l, int r, boolean ignoredOnce) {

        while(l < r) {
            char left = s.charAt(l);
            char right = s.charAt(r);

            if(left != right) {

                if(ignoredOnce) {
                    return false;
                } else {
                    return isPalindromeUtil(s, l, r - 1, true) || isPalindromeUtil(s, l + 1, r, true);
                }

            }

            l++;
            r--;
        }

        return true;
    }
}

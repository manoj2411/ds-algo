/*
	https://leetcode.com/problems/remove-palindromic-subsequences/
*/
class RemovePalindromicSubsequences {
	public static void main(String[] args) {
		String[] input = {"ababa", "baabb", "abb", "b", ""};

		for(String str : input)
			System.out.println("'" + str + "' : " +
				new Solution().removePalindromeSub(str));

	}
}

class Solution {
    public int removePalindromeSub(String s) {
        if (s.isEmpty()) return 0;
        else if (isPalindrome(s)) return 1;
        else return 2;
    }

    boolean isPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j))
                return false;
        }

        return true;
    }
}

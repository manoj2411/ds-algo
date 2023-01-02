/*
	https://leetcode.com/problems/detect-capital/description/
*/
class DetectCapital {
	public static void main(String[] args) {

		System.out.println(new Solution().detectCapitalUse("USA")); // true

		System.out.println(new Solution().detectCapitalUse("FlaG")); // false
	}
}

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.equals(word.toUpperCase())) {
            return true;
        }

        String wordExceptFirstChar = word.substring(1);
        if (wordExceptFirstChar.equals(wordExceptFirstChar.toLowerCase())) {
            return true;
        }

        return false;
    }
}

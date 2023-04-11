/*
	https://leetcode.com/problems/removing-stars-from-a-string/description/
*/
class RemovingStarsFromString {
	public static void main(String[] args) {
		System.out.println(new Solution().removeStars("leet**cod*e")); // lecoe
		System.out.println(new Solution().removeStars("erase*****")); // ""
	}
}

class Solution {
    public String removeStars(String s) {
    	// use StringBuilder a stack
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()) {
            if (ch == '*') {
                sb.setLength(sb.length() - 1);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}

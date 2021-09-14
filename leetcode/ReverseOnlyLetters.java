/*
	https://leetcode.com/problems/reverse-only-letters/
*/
class ReverseOnlyLetters {
	public static void main(String[] args) {
		System.out.println(new Solution().reverseOnlyLetters("a-bC-dEf-ghIj")); // "j-Ih-gfE-dCba"
	}
}

class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int right = s.length() - 1;

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLetter(ch)) {

                while(!Character.isLetter(s.charAt(right)))
                    right--;
                sb.append(s.charAt(right--));
            } else {
                sb.append(ch);
            }

        }
        return sb.toString();
    }
}

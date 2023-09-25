/*
    https://leetcode.com/problems/find-the-difference/description/
*/

class FindTheDifference {
    public static void main(String... args) {
        System.out.println(new Solution().findTheDifference("", "y")); // y
        System.out.println(new Solution().findTheDifference("abcd", "abacd")); // a
    }
}

class Solution {

    public char findTheDifference(String s, String t) {
        int[] chars = new int[26];

        for(int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'a']--;
            chars[t.charAt(i) - 'a']++;
        }
        chars[t.charAt(s.length()) - 'a']++;

        for(int i = 0; i < 26; i++) {
            if (chars[i] > 0) {
                return (char)('a' + i);
            }
        }
        return ' ';
    }
}

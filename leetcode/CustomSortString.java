/*
	https://leetcode.com/problems/custom-sort-string/
*/
class CustomSortString {
	public static void main(String[] args) {
		String order = "cba";
		String str = "abcd";
		System.out.println(new Solution().customSortString(order, str)); // "cbad"
	}
}


class Solution {
    public String customSortString(String order, String str) {
        int[] charCount = new int[26];

        for(char ch : str.toCharArray()) charCount[ch-'a']++;

        StringBuilder res = new StringBuilder();

        for(char ch : order.toCharArray()) {
            for(int i = 0; i < charCount[ch-'a']; i++)
                res.append(ch);

            charCount[ch-'a'] = 0;
        }

        for(int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            for(int j = 0; j < charCount[i]; j++) {
                res.append(ch);
            }
        }

        return res.toString();
    }
}

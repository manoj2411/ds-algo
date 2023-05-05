/*
	https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
*/
class MaxNumberOfVowelsInaSubstringOfGivenLength {

	public static void main(String[] args) {
		System.out.println(new Solution().maxVowels("abciiidef", 3)); 	// 3
		System.out.println(new Solution().maxVowels("aeiou", 2)); 		// 2
		System.out.println(new Solution().maxVowels("leetcode", 3)); 	// 2
	}

}

class Solution {

    private static final char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    private int[] count = new int[26];

    public int maxVowels(final String s, final int k) {

        for(int i = 0; i < k; i++) {
            char ch = s.charAt(i);
            count[ch-'a']++;
        }

        int maxCount = countVowels();
        for(int i = k, j = 0; i < s.length(); i++, j++) {
            count[s.charAt(j)-'a']--;
            count[s.charAt(i)-'a']++;
            maxCount = Math.max(maxCount, countVowels());
        }

        return maxCount;
    }

    private int countVowels() {
        int c = 0;
        for(char ch : vowels) {
            c += count[ch-'a'];
        }
        return c;
    }
}

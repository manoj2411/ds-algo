class MinimumLengthSubstrings {
	public static void main(String[] args) {
    	String s_1 = "dcbefebce";
    	String t_1 = "fd";
    	System.out.println(new Solution().minLengthSubstring(s_1, t_1)); // 5

    	String s_2 = "bfbeadbcbcbfeaaeefcddcccbbbfaaafdbebedddf";
    	String t_2 = "cbccfafebccdccebdd";
    	System.out.println(new Solution().minLengthSubstring(s_2, t_2)); // -1

        s_1 = "abcaabcdcccafb";
        t_1 = "abd";
    	System.out.println(new Solution().minLengthSubstring(s_1, t_1)); // 4
	}
}

class Solution {
	// assumption is we have only lower case letters in s and t.
	private boolean isValid(int[] schars, int[] tchars) {

		for(int i = 0; i < 26; i++) {
			if(schars[i] < tchars[i])
				return false;
		}
		return true;
	}

	int minLengthSubstring(String s, String t) {
    	// Write your code here
		int slen = s.length();

		int[] tchars = new int[26];
		for(char ch : t.toCharArray())
			tchars[ch - 'a']++;

		int[] schars = new int[26];

		int start = 0;
		int end = 0;
		int best = s.length() + 1;

		while(end < slen) {

			while(!isValid(schars, tchars) && end < slen) {
				schars[s.charAt(end++) - 'a']++;
			}

			while(isValid(schars, tchars)) {
				best = Math.min(best, end - start);
				schars[s.charAt(start++) - 'a']--;
			}
		}

		return best <= s.length() ? best : -1;
	}
}

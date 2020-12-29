class LongestCommonSubstring {
	public static void main(String[] args) {
		String[][] input = {{"ABCDGH", "ACDGHR"}, {"ABC", "AC"}};

		for(String[] arr : input) {
			String s1 = arr[0];
			String s2 = arr[1];
			System.out.println("s1: " + s1 + "\ns2: " + s2);
			System.out.println("Length of longest common substring: " + lcs(s1, s2));
			System.out.println();
		}
	}

	static int lcs(String s1, String s2) {

	   int max = 0;

	   int[][] dp = new int[s1.length() + 1][s2.length() + 1];

	   for(int i = 1; i <= s1.length(); i++) {
	       for(int j = 1; j <= s2.length(); j++) {
	           if(s1.charAt(i-1) == s2.charAt(j-1)) {
	               dp[i][j] = 1 + dp[i-1][j-1];
	               max = Math.max(dp[i][j], max);
	           }

	       }
	   }
	   return max;
	}

	// It is expensive : N * N * (N*N for substring) : M = N
	static int lcsByLen(String s1, String s2) {
	   for(int len = s1.length(); len > 0; len--) {
	       for(int s = 0; s + len <= s1.length(); s++) {
	           String str = s1.substring(s, s+len);
	           if(s2.contains(str))
	               return len;
	       }
	   }
	   return 0;
	}

}
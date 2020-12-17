class LongestPalindromicSubstr {

	public static void main(String[] args) {
		String[] input = {"aaaabbaa", "geeks"};
		for(String str : input) {
			System.out.println("Str: " + str);
			System.out.println("Longest palindromic substr: " + lps(str));
			System.out.println();
		}
	}

	static String lps(String str) {

	   // for(int len = str.length(); len > 0; len--) {
	   //     for(int i = 0; i + (len - 1) < str.length(); i++) {
	   //         if(isPalindrome(str, i, i + (len - 1)))
	   //             return str.substring(i, i + len);
	   //     }
	   // }
	    String[] res = { "" };

	    helper(str, 0, str.length() - 1, res);

	    return res[0];
	}

	static void helper(String str, int l, int r, String[] res) {
	    if(res[0].length() >= r - l + 1 || l > r)
	        return;
	    if(isPalindrome(str, l, r)) {
	        res[0] = str.substring(l, r + 1);
	        return;
	    }
	    helper(str, l, r - 1, res);
	    helper(str, l + 1, r, res);
	}

	static boolean isPalindrome(String str, int l, int r) {
	    while(l < r) {
	        if(str.charAt(l++) != str.charAt(r--))
	            return false;

	    }
	    return true;
	}
}
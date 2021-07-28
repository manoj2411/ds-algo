class EncryptedWords {
	public static void main(String[] args) {
		System.out.println(new Solution().findEncryptedWord("abc")); 		// bac
		System.out.println(new Solution().findEncryptedWord("abcd")); 		// bacd
		System.out.println(new Solution().findEncryptedWord("abcxcba")); 	// xbacbca
		System.out.println(new Solution().findEncryptedWord("facebook")); 	// eafcobok
		System.out.println(new Solution().findEncryptedWord("a")); 			// a
		System.out.println(new Solution().findEncryptedWord("aa")); 		// aa
		System.out.println(new Solution().findEncryptedWord("ab")); 		// ab
	}

}


class Solution {
	private StringBuilder encrypt(String s, int left, int right) {

	    StringBuilder result = new StringBuilder();

	    if (left > right) return result;

	    if (left == right) {
	      result.append(s.charAt(left));
	      return result;
	    }

	    int mid = (left + right) / 2;

	    result.append(s.charAt(mid));
	    result.append(encrypt(s, left, mid - 1));
	    result.append(encrypt(s, mid + 1, right));

	    return result;

  	}

  	String findEncryptedWord(String s) {
    	return encrypt(s, 0, s.length() - 1).toString();
  	}
}

import java.util.*;

/*
	https://leetcode.com/problems/check-if-a-string-contains-all-binary-codes-of-size-k/
*/
class StrContainsAllBinaryCodesOfSizeK {
	public static void main(String[] args) {
		String str = "00110110";
		System.out.println(new Solution().hasAllCodes(str, 2)); // true
		System.out.println(new Solution().hasAllCodes("0110", 2)); // false

	}
}

class Solution {
    public boolean hasAllCodes(String s, int k) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i + k <= s.length(); i++)
            set.add(s.substring(i, i+k));

        return set.size() == (int)Math.pow(2, k);
    }
}

/*
		https://leetcode.com/problems/count-binary-substrings/
*/
class CountBinarySubstrings {
	public static void main(String[] args) {
		String[] input = { "00110011", "10101"}; // res : 6, 4

		for(String str : input) {
			System.out.println(new Solution().countBinarySubstrings(str));
		}
	}
}

class Solution {

	/*
		complexity:
			time	: O(N), single pass
			space 	: O(1)
	*/
    public int countBinarySubstrings(String s) {

        int[] counts = {0, 0};

        int res = 0;

        counts[s.charAt(0) - '0']++;

        for(int i = 1; i < s.length(); i++) {

            if (s.charAt(i) != s.charAt(i-1)) {
                res += Math.min(counts[0], counts[1]);
                counts[s.charAt(i) - '0'] = 0;
            }

            counts[s.charAt(i) - '0']++;
        }

        res += Math.min(counts[0], counts[1]);

        return res;
    }
}

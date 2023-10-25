/*
	https://leetcode.com/problems/k-th-symbol-in-grammar/
*/
class KthSymbolInGrammar {
	public static void main(String... args) {
		System.out.println(new Solution().kthGrammar(1, 1)) ; // 0
		System.out.println(new Solution().kthGrammar(3, 3)) ; // 1
		System.out.println(new Solution().kthGrammar(4, 3)) ; // 1
		System.out.println(new Solution().kthGrammar(4, 4)) ; // 0
		System.out.println(new Solution().kthGrammar(30, 434991989)) ; // 0
	}
}

class Solution {
    public int kthGrammar(int n, int k) {
        return solve(n, k - 1);
    }

    private int solve(int n, int k) {
        if (n == 1) return 0;

        // find last value from prev row to calculate curr row value
        int last = solve(n-1, k / 2);

        if (last == 0) {
            // if last was 0 then curr will be 0 for (k/2) * 1 for (k/2)+1
            return k % 2 == 0 ? 0 : 1;
        } else { // last == 1
            // if last was 1 then curr will be 1 for (k/2) * 0 for (k/2)+1
            return k % 2 == 0 ? 1 : 0;
        }
    }
}

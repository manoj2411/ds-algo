import java.util.*;

/*
	https://leetcode.com/problems/matchsticks-to-square/
*/
class MatchsticksToSquare {
	public static void main(String[] args) {
		int[] arr = {1,1,2,2,2,1,1,2,2,2,1,1,2,2,2};
		System.out.println(new Solution().makesquare(arr)); // true

		arr = new int[] {0,0,0,0};
		System.out.println(new Solution().makesquare(arr)); // false

		arr = new int[] {1,1,2,2,2};
		System.out.println(new Solution().makesquare(arr)); // true
	}
}


class Solution {
    int[] matchsticks;
    int side;

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;

        Arrays.sort(matchsticks);

        this.matchsticks = matchsticks;

        for(int matchstick : matchsticks) sum += matchstick;

        if (sum % 4 != 0 || sum == 0) return false;

        side = sum / 4;

        return solve(0, 0, 0, 0, matchsticks.length - 1);
    }

    private boolean solve(int s1, int s2, int s3, int s4, int i) {

        if (i == -1)
            return s1 == s2 && s2 == s3 && s3 == s4 && s4 == side;

        if (s1 > side || s2 > side || s3 > side || s4 > side) return false;

        int curr = matchsticks[i];

        return solve(s1 + curr, s2, s3, s4, i - 1) ||
            solve(s1, s2 + curr, s3, s4, i - 1) ||
            solve(s1, s2, s3 + curr, s4, i - 1) ||
            solve(s1, s2, s3, s4 + curr, i - 1);

    }
}

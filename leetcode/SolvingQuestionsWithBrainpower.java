/*
	https://leetcode.com/problems/solving-questions-with-brainpower/description/
*/
class SolvingQuestionsWithBrainpower {
	public static void main(String[] args) {
		int[][] input = {{3,2},{4,3},{4,4},{2,5}};
		System.out.println(new Solution().mostPoints(input)); 	// 5

		input = new int[][]{{1,1},{2,2},{3,3},{4,4},{5,5}};
		System.out.println(new Solution().mostPoints(input)); 	// 7

		input = new int[][]{{21,5},{92,3},{74,2},{39,4},{58,2},{5,5},{49,4},{65,3}};
		System.out.println(new Solution().mostPoints(input)); 	// 157
	}
}

class Solution {

    public long mostPoints(int[][] questions) {
        int len = questions.length;
        long[] points = new long[len];
        points[len-1] = questions[len-1][0];

        for(int i = len-2; i >= 0; i--) {
            long curr = questions[i][0];
            int bp = questions[i][1];
            int nexti = i + bp + 1;
            if (nexti < len) {
                curr += points[nexti];
            }

            points[i] = Math.max(points[i+1], curr);
        }
        return points[0];
    }
}

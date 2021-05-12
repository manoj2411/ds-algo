/*
	https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
*/
class MaxPointsYouCanObtainFromCards {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,1};
		int k = 3;
		System.out.println(new Solution().maxScore(arr, k)); // 12
	}
}

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int total = 0;

        for(int p : cardPoints) total += p;

        if(k == len) return total;


        int excludedCardPoints = 0;
        for(int i = 0; i < len - k; i++)
        	excludedCardPoints += cardPoints[i];

        int maxPoints = total - excludedCardPoints;
        for(int i = len - k; i < len; i++) {
            excludedCardPoints += cardPoints[i];
            excludedCardPoints -= cardPoints[i-(len-k)];
            maxPoints = Math.max(maxPoints, total - excludedCardPoints);
        }

        return maxPoints;
    }
}

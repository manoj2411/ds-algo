/*
	https://leetcode.com/problems/find-the-winner-of-an-array-game/description/
*/
class FindTheWinnerOfArrayGame {
	public static void main(String... args) {
		int[] input = {2,1,3,5,4,6,7};
		int k = 2;
		System.out.println(new Solution().getWinner(input, k)); // 5
	}
}

class Solution {
    public int getWinner(int[] arr, int k) {

        int winner = arr[0];
        int count = 0;

        for(int i = 1; i < arr.length && count < k; i++) {
            int curr = arr[i];
            if (curr > winner) {
                winner = curr;
                count = 1;
            } else {
                count++;
            }
        }
        return winner;
    }
}

/**

    que : 6,7,1,2,3,4

    winner: 5
    count: 2
 */

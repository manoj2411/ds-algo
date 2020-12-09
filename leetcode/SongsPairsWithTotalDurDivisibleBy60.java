import java.util.*;

/*
	https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
*/
class SongsPairsWithTotalDurDivisibleBy60 {

	public static void main(String[] args) {
		int[][] input = {
			{30,20,150,100,40,180,80}, // 5
			{60,60,180}, // 3
		};
		for(int[] time : input) {
			Solution sol = new Solution();
			System.out.println("time: " + Arrays.toString(time) + " : " +
				sol.numPairsDivisibleBy60(time));

		}
	}
}

class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        for(int i = 0; i < time.length; i++)
            time[i] = time[i] % 60;

        int counter = 0;
        // Map<Integer, Integer> map = new HashMap<>();
        int[] map = new int[60];
        for(int item : time) {
            int c;
            if(item == 0) {
                c = map[0];
            } else {
                c = map[60 - item];
            }
            counter += c;
            map[item]++;
        }

        return counter;
    }
}
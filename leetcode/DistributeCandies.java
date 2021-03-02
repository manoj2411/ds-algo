import java.util.*;

/*
		https://leetcode.com/problems/distribute-candies/
*/
class DistributeCandies {
	public static void main(String[] args) {
		int[][] input = {
			{1,1,2,2,3,3},
			{1,1,2,3},
			{6,6,6,6},
		};

		for(int[] arr : input) {
			System.out.println("Candy types: " + Arrays.toString(arr) +
				", #types Alice can eat : " + new Solution().distributeCandies(arr));
			System.out.println();
		}
	}
}

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>(candyType.length, 1f);

        int max = candyType.length / 2;

        for(int type : candyType) {
            set.add(type);
            if(set.size() == max) return max;
        }

        return set.size();
    }
}

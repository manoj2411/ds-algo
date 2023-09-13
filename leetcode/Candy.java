import java.util.*;

/*
	https://leetcode.com/problems/candy/description/
*/
class Candy {
	public static void main(String... args) {
		int[] ratings1 = {1,0,2};
		System.out.println(new Solution().candy(ratings1)); // 5

		int[] ratings2 = {1,2,2};
		System.out.println(new Solution().candy(ratings2)); // 4

		int[] ratings3 = {1,2,87,87,87,2,1};
		System.out.println(new Solution().candy(ratings3)); // 13
	}
}

class Solution {

    public int candy(int[] ratings) {

      List<Integer> indices = new ArrayList<>();
      for(int i = 0; i < ratings.length; i++) {
        indices.add(i);
      }
      Collections.sort(indices, (a, b) -> Integer.compare(ratings[a], ratings[b]));

      int[] candies = new int[ratings.length];
      for(int i : indices) {
        int candy = 0;

        if (i-1 >= 0 && ratings[i-1] < ratings[i]) {
          candy = candies[i-1];
        }

        if (i+1 < ratings.length && ratings[i+1] < ratings[i]) {
          candy = Math.max(candies[i+1], candy);
        }

        candies[i] = candy + 1;
      }

      return sum(candies);
    }

    private int sum(int[] arr) {
      int sum = 0;
      for(int n : arr) sum += n;
      return sum;
    }
}

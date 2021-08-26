import java.util.*;

/*
	https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
*/
class CapacityToShipPackagesWithinDDays {
	public static void main(String[] args) {
		int[] weights = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(new Solution().shipWithinDays(weights, 5)); // 15

		weights = new int[] {3,2,2,4,1,4};
		System.out.println(new Solution().shipWithinDays(weights, 3)); // 6

		weights = new int[] {3,2,2,4,1,4};
		System.out.println(new Solution().shipWithinDays(weights, 5)); // 4

		weights = new int[] {3,2,2,4,1,4};
		System.out.println(new Solution().shipWithinDays(weights, 6)); // 4

		weights = new int[] {1,2,3,1,1};
		System.out.println(new Solution().shipWithinDays(weights, 4)); // 3

	}
}


class Solution {

    public int shipWithinDays(int[] weights, int days) {

        int high = Arrays.stream(weights).sum();
        int low = Arrays.stream(weights).min().getAsInt();

        int result = high;

        while (low <= high) {
            int pivot = (low + high) / 2;

            if (isValid(weights, days, pivot)) {
                result = pivot;
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }

        return result;
    }

    private boolean isValid(int[] weights, int days, int maxWeight) {

        int currDays = 1;
        int totalWeight = 0;
        for(int weight : weights) {

            if (weight > maxWeight) return false;

            totalWeight += weight;

            if (totalWeight > maxWeight) {
                currDays++;
                totalWeight = weight;

                if (currDays > days) return false;
            }
        }

        return true;
    }
}

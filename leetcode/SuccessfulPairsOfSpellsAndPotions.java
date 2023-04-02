import java.util.*;

/*
	https://leetcode.com/problems/successful-pairs-of-spells-and-potions/description/
*/

class SuccessfulPairsOfSpellsAndPotions {
	public static void main(String[] args) {
		int[] spells = {5,1,3};
		int[] potions = {1,2,3,4,5};

		System.out.println(Arrays.toString(
			new Solution().successfulPairs(spells, potions, 7) // [4,0,3]
		));
	}
}

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);

        for(int i = 0; i < spells.length; i++) {
            result[i] = solve(spells[i], potions, success);
        }

        return result;
    }

    private int solve(long spell, int[] potions, long success) {
        int left = 0;
        int right = potions.length - 1;

        if (potions[right] * spell < success) {
            return 0;
        } else if (potions[left] * spell >= success) {
            return right + 1;
        }

        while(right - left > 1) {
            int mid = (right + left) / 2;

            if (potions[mid] * spell >= success) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (potions[left] * spell >= success) {
            return potions.length - left;
        } else {
            return potions.length - right;
        }
    }
}

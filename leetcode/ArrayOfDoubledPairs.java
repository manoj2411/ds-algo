import java.util.*;

/*
	https://leetcode.com/problems/array-of-doubled-pairs/
*/
class ArrayOfDoubledPairs {
	public static void main(String[] args) {
		int[] arr = {1,2,4,16,8,4};
		System.out.println(new Solution().canReorderDoubled(arr)); // false

		arr = new int[] { 4,-2,2,-4 };
		System.out.println(new Solution().canReorderDoubled(arr)); // true
	}
}

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int num : arr) {
            if (!count.containsKey(num))
                count.put(num, 0);

            count.put(num, 1 + count.get(num));
        }

        Arrays.sort(arr);

        for(int num : arr) {
            if (count.get(num) == 0) continue;

            int matching;
            if (num < 0) {
                if (num % 2 != 0) return false;
                matching = num / 2;
            } else {
                matching = num * 2;
            }

            if (count.getOrDefault(matching, 0) == 0) return false;

            count.put(num, count.get(num) - 1);
            count.put(matching, count.get(matching) - 1);
        }

        return true;
    }
}

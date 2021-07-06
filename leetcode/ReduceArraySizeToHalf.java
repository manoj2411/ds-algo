import java.util.*;

/*
	https://leetcode.com/problems/reduce-array-size-to-the-half/
*/
class ReduceArraySizeToHalf {
	public static void main(String[] args) {
		int[] arr = {3,3,3,3,5,5,5,2,2,7};
		System.out.println(new Solution().minSetSize(arr));
	}
}

class Solution {
    public int minSetSize(int[] arr) {
        int len = arr.length;

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr) {
            int count = map.getOrDefault(num, 0);
            map.put(num, count + 1);
        }

        List<Integer> sortedCounts = new ArrayList<Integer>(map.values());
        Collections.sort(sortedCounts, Collections.reverseOrder());

        int setsRemoved = 0;
        int itemsRemoved = 0;
        for (int i = 0; i < sortedCounts.size(); i++) {
            itemsRemoved += sortedCounts.get(i);
            setsRemoved++;
            if (itemsRemoved >= len / 2)
                return setsRemoved;

        }
        return setsRemoved;
    }
}

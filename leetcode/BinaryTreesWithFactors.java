import java.util.*;

/*
	https://leetcode.com/problems/binary-trees-with-factors/
*/
class BinaryTreesWithFactors {
	public static void main(String[] args) {
		int[] arr = {2,4};
		System.out.println(new Solution().numFactoredBinaryTrees(arr)); // 3

		arr = new int[] { 2, 4, 5, 10, 20};
		System.out.println(new Solution().numFactoredBinaryTrees(arr)); // 18
	}
}

class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        Arrays.sort(arr);
        long max = (long)Math.pow(10,9) + 7l;
        Map<Integer, List<Integer>> factors = buildFactors(arr);
        Set<Integer> set = new HashSet<>(arr.length, 1f);
        Map<Integer, Long> subtreeCount = new HashMap<>();

        long totalTrees = 0;

        // System.out.println(factors);

        for(int e : arr) {
            set.add(e);
            long count = 1l;

            for(int factor : factors.get(e)) {
                int f2 = e / factor;

                if ( set.contains(f2)) {
                    count += subtreeCount.get(factor) * subtreeCount.get(f2);
                }
            }
            subtreeCount.put(e, count);
            totalTrees += count;
        }

        return (int)(totalTrees % max);

    }

    private Map<Integer, List<Integer>> buildFactors(int[] arr) {
        Map<Integer, List<Integer>> factors = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int e = arr[i];
            factors.put(e, new ArrayList<>());

            for(int j = 0; j < i; j++) {
                if (e % arr[j] == 0) {
                    factors.get(e).add(arr[j]);
                }
            }
        }
        return factors;
    }
}

import java.util.*;

class PermutationsII {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] inputs = {{1,2,3}, {2,1,2}};

        for(int[] nums : inputs) {
            System.out.println("nums: " + Arrays.toString(nums));
            System.out.println("permutations: " + sol.permuteUnique(nums));
        }
    }
}

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] num = new int[nums.length];
        int[] count = new int[21];
        for(int n : nums) {
            count[n + 10]++;
        }
        helper(nums, 0, num, count, result);
        return result;
    }

    private void helper(int[] nums, int i, int[] num, int[] count, List<List<Integer>> result) {
        if(i == num.length) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < i; j++)
                list.add(num[j]);
            result.add(list);
            return;
        }

        for(int j = 0; j < 21; j++) {
            if(count[j] > 0) {
                int n = j - 10;
                num[i] = n;
                count[j]--;
                helper(nums, i + 1, num, count, result);
                count[j]++;
            }
        }
    }
}

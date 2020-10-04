import java.util.*;

/*
        https://leetcode.com/problems/combination-sum/
*/

class CombinationSum {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] candidates = {2,3,5};
        int target = 8;
        System.out.println(sol.combinationSum(candidates, target));
    }
}

class Solution {
    List<List<Integer>> result;
    Map<int[], List<Integer>>cache;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new LinkedList<>();
        List<Integer> curr = new LinkedList<>();
        cache = new HashMap<>();
        helper(candidates, target, 0, curr);
        return result;
    }

    void helper(int[] candidates, int target, int i, List<Integer> curr) {
        if(i == candidates.length) {
            return;
        } else if(target == 0) {
            if(!curr.isEmpty()) result.add(curr);
        } else if(candidates[i] > target) {
            helper(candidates, target, i + 1, curr);
        } else {
            List<Integer> nextCurr = new LinkedList<>(curr);
            nextCurr.add(candidates[i]);
            helper(candidates, target - candidates[i], i, nextCurr);
            helper(candidates, target, i + 1, curr);
        }
    }
}

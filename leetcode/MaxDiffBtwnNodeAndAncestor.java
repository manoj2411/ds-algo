/*
    https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
*/
class MaxDiffBtwnNodeAndAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.right = new TreeNode(0);
        root.right.left = new TreeNode(1);

        Solution sol = new Solution();
        // res : 2
        System.out.println(sol.maxAncestorDiff(root));
    }
}


class Solution {

    public int maxAncestorDiff(TreeNode root) {
        int[] result = {0};
        helper(root, result, root.val, root.val);
        return result[0];
    }

    private void helper(TreeNode node, int[] result, int min, int max) {
        if(node == null) return;

        int val = node.val;

        int minDiff = Math.abs(val - min);
        int maxDiff = Math.abs(max - val);

        result[0] = Math.max(result[0], Math.max(minDiff, maxDiff));

        int nextMin = Math.min(min, val);
        int nextMax = Math.max(max, val);

        helper(node.left, result, nextMin, nextMax);
        helper(node.right, result, nextMin, nextMax);
    }
}
/**
 * Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

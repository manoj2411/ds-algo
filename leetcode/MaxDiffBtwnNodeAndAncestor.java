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
        return maxDiff(root, root.val, root.val);

    }

    private int maxDiff(TreeNode node, int min, int max) {
        if (node == null) return 0;

        int diff = Math.max(Math.abs(min - node.val), Math.abs(max - node.val));

        int newMin = Math.min(min, node.val);
        int newMax = Math.max(max, node.val);
        int leftMax = maxDiff(node.left, newMin, newMax);
        int rightMax = maxDiff(node.right, newMin, newMax);
        return Math.max(diff, Math.max(leftMax, rightMax));
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

/*
	https://leetcode.com/problems/sum-of-left-leaves/
*/

class SumOfLeftLeaves {
	public static void main(String[] args) {
		var root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(new Solution().sumOfLeftLeaves(root)); // 24
	}
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        return helper(root, false);
    }

    private int helper(TreeNode node, boolean isLeft) {
        if (node == null){
            return 0;
        } else if (node.left == null && node.right == null) {
            return isLeft ? node.val : 0;
        } else {
            return helper(node.left, true) + helper(node.right, false);
        }
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

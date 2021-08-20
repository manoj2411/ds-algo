/*
	https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
*/
class MaximumProductOfSplittedBinTree {
	public static void main(String[] args) {
		var root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		System.out.println(new Solution().maxProduct(root)); // 110
	}
}


class Solution {

    long result;
    static int MAX = 1000000007;

    public int maxProduct(TreeNode root) {

        long total = treeSum(root, 0l);

        result = 0l;
        treeSum(root, total);

        return (int)(result % MAX);
    }

    long treeSum(TreeNode root, long total) {
        if (root == null) return 0;

        long leftSum = treeSum(root.left, total);
        long rightSum = treeSum(root.right, total );

        result = Math.max(result, Math.max(
            leftSum * (total - leftSum),
            rightSum * (total - rightSum) ));

        return root.val +  leftSum + rightSum;
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

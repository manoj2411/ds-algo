/*
	https://leetcode.com/problems/minimum-distance-between-bst-nodes/description/
*/
class MinDistanceBetweenBSTNodes {
	public static void main(String[] args) {
		var root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);

		System.out.println(new Solution().minDiffInBST(root)); // 1
	}
}


class Solution {

    int minDistance = 100002;
    int prev = 100001;

    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return minDistance;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        int curr = root.val;
        minDistance = Math.min(minDistance, Math.abs(curr - prev));
        prev = curr;

        inorder(root.right);

    }
}

/**	Definition for a binary tree node.	*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

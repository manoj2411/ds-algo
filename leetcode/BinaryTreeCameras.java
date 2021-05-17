/*
    https://leetcode.com/problems/binary-tree-cameras/
*/
class BinaryTreeCameras {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(0);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(0);
		root.left.left.right = new TreeNode(0);

		System.out.println(new Solution().minCameraCover(root)); // 2
	}
}

class Solution {
    int cameras;

    public int minCameraCover(TreeNode root) {
        cameras = 0;

        var rootState = helper(root);

        if (rootState == State.NEED) cameras++;

        return cameras;
    }

    private State helper(TreeNode root) {
        if (root == null)
            return State.NO_NEED;
        else if (root.left == null && root.right == null)
            return State.NEED;

        var leftChildState = helper(root.left);
        var rightChildState = helper(root.right);

        if (leftChildState == State.NEED || rightChildState == State.NEED) {
            cameras++;
            return State.GIVING;
        }

        if (leftChildState == State.GIVING || rightChildState == State.GIVING) {
            return State.NO_NEED;
        }

        return State.NEED;

    }
}

enum State { NEED, GIVING, NO_NEED};

/*	Definition for a binary tree node.	*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

/*
	https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
*/
class TwoSumIV_InputIsaBST {
	public static void main(String[] args) {
		var root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);

		System.out.println(new Solution().findTarget(root, 4)); // true
		System.out.println(new Solution().findTarget(root, 2)); // false
		System.out.println(new Solution().findTarget(root, 3)); // true
		System.out.println(new Solution().findTarget(root, 1)); // false
	}
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        return hasTwoSum(root, k, root);
    }

    boolean hasTwoSum(TreeNode root, int k, TreeNode curr) {
        if (curr == null) return false;

        if (hasValue(root, k - curr.val, curr.val))
            return true;

        return hasTwoSum(root, k, curr.left) || hasTwoSum(root, k, curr.right);

    }

    boolean hasValue(TreeNode root, int t, int selected) {
        if (root == null || root.val == selected) return false;
        if (root.val == t) return true;

        return (root.val < t) ? hasValue(root.right, t, selected) : hasValue(root.left, t, selected);
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

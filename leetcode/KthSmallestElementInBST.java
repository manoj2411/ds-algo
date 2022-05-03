/*
	https://leetcode.com/problems/kth-smallest-element-in-a-bst/
*/
class KthSmallestElementInBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.right = new TreeNode(2);

		System.out.println(new Solution().kthSmallest(root, 2)); // 2
		System.out.println(new Solution().kthSmallest(root, 1)); // 1
	}
}

class Solution {

    int result;

    public int kthSmallest(TreeNode root, int k) {
        count(root, k);

        return result;
    }

    private int count(TreeNode node, int k) {
        if (node == null || k < 1 ) return 0;

        int nodes = count(node.left, k) + 1;

        if (nodes == k) {
            result = node.val;
        }

        nodes += count(node.right, k - nodes);

        return nodes;
    }
}

/**	Definition for a binary tree node. */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

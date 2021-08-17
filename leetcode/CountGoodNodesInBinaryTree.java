/*
	https://leetcode.com/problems/count-good-nodes-in-binary-tree/
*/
class CountGoodNodesInBinaryTree {
	public static void main(String[] args) {
		var root = new TreeNode(3);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(2);
		System.out.println(new Solution().goodNodes(root)); // 3
	}
}



class Solution {
    public int goodNodes(TreeNode root) {
        return countgoodNodes(root, root.val);
    }

    int countgoodNodes(TreeNode node, int max) {

        if (node == null) return 0;

        int result = node.val >= max ? 1 : 0;

        max = Math.max(max, node.val);
        result += countgoodNodes(node.left, max);
        result += countgoodNodes(node.right, max);

        return result;
    }
}

/**	Definition for a binary tree node.	 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

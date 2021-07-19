/*
	https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
*/
class LowestCommonAncestorOfBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(0);
		root.right = new TreeNode(3);

		var result = new Solution().lowestCommonAncestor(root, root.left, root.left.left);
		System.out.println(result.val); // 1
	}
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == p) return p;
        else if (root == q) return q;
        else if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

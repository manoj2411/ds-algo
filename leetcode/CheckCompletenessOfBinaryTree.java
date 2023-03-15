import java.util.*;

/*
	https://leetcode.com/problems/check-completeness-of-a-binary-tree/
*/
class CheckCompletenessOfBinaryTree {
	public static void main(String[] args) {
		var root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left = new TreeNode(4);
		System.out.println(new Solution().isCompleteTree(root)); // true
	}
}

class Solution {
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> que = new LinkedList<>();
        boolean firstNull = false;
        que.add(root);

        while(!que.isEmpty()) {
            TreeNode curr = que.poll();
            if (firstNull && curr != null) {
                return false;
            } else if (curr == null) {
                firstNull = true;
            } else {
                que.add(curr.left);
                que.add(curr.right);
            }
        }

        return true;

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

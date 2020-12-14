import java.util.*;

/*
	https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
*/
class SmallestSubtreeWithAllDeepestNodes {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.right = new TreeNode(7);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(15);
		Solution sol = new Solution();
		TreeNode res = sol.subtreeWithAllDeepest(root);
		System.out.println("Root of smallest subtree with all deepest nodes: " + res.val);
	}
}

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if(root.left == null && root.right == null) return root;

        Deque<TreeNode> que = new LinkedList<>();
        que.add(root);

        TreeNode left = null, right = null;

        while(!que.isEmpty()) {

            int size = que.size();

            for(int i = 0; i < size; i++) { // level order traversal
                TreeNode node = que.remove();

                if(node.left != null) {
                    que.add(node.left);
                }
                if(node.right != null) {
                    que.add(node.right);
                }
            }

            if(que.size() > 0) {
                left = que.peekFirst();
                right = que.peekLast();
            }
        }

        if(left.val == right.val)
            return left;
        else
            return lca(root, left, right);
    }

    TreeNode lca(TreeNode root, TreeNode n1, TreeNode n2) {
        TreeNode[] res = {null};
        lcaHelper(root, n1, n2, res);
        return res[0];
    }

    boolean lcaHelper(TreeNode root, TreeNode n1, TreeNode n2, TreeNode[] res) {
        if(root == null)
            return false;
        else if(root.val == n1.val || root.val == n2.val)
            return true;
        else {
            boolean left = lcaHelper(root.left, n1, n2, res);
            boolean right = lcaHelper(root.right, n1, n2, res);

            if(left && right) {
                res[0] = root;
            }

            return left || right;
        }


    }
}

/**
   Definition for a binary tree node.
*/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

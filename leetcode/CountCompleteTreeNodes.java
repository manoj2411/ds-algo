/*
	https://leetcode.com/problems/count-complete-tree-nodes/
*/
class CountCompleteTreeNodes {
	public static void main(String[] args) {
		var root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(5);
		root.left.right = new TreeNode(7);
		root.right.left = new TreeNode(6);

		System.out.println(new Solution().countNodes(root)); // 6

		System.out.println(new Solution().countNodes(null)); // 0

		System.out.println(new Solution().countNodes(new TreeNode(2))); // 1
	}
}

class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int height = findHeight(root);

        int left = 1;
        int right = (int)Math.pow(2, height);

        while(right - left > 1) {
            int mid = (left + right) / 2;

            if(isNodeExists(root, mid, height)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        int lastLeft = isNodeExists(root, right, height) ? right : left;

        return ((int)Math.pow(2, height)- 1) + lastLeft;
    }

    private boolean isNodeExists(TreeNode root, int num, int level) {
        if (root == null) return false;
        else if (level == 0) return true;

        int leftNodesCount = (int)Math.pow(2, level) / 2;

        if (leftNodesCount >= num) { // go left
            return isNodeExists(root.left, num, level - 1);
        } else { // go right
            return isNodeExists(root.right, num - leftNodesCount, level - 1);
        }
    }

    private int findHeight(TreeNode root) {
        if (root.left == null) return 0;
        return 1 + findHeight(root.left);
    }

}

/** Definition for a binary tree node. 	 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

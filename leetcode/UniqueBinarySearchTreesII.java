import java.util.*;

/*
	https://leetcode.com/problems/unique-binary-search-trees-ii/
*/
class UniqueBinarySearchTreesII {
	public static void main(String[] args) {
		var trees = new Solution().generateTrees(1);
		System.out.println(trees.size()); // 1

		trees = new Solution().generateTrees(3);
		System.out.println(trees.size()); // 5
	}
}

class Solution {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n);
    }

    private List<TreeNode> generate(int min, int max) {

        if (min > max) return new ArrayList<>();
        if (min == max) return List.of(new TreeNode(min));

        List<TreeNode> result = new ArrayList<>();

        for(int rootVal = min; rootVal <= max; rootVal++) {

            List<TreeNode> lefts = generate(min, rootVal - 1);
            List<TreeNode> rights = generate(rootVal + 1, max);

            if (lefts.isEmpty()) lefts.add(null);
            if (rights.isEmpty()) rights.add(null);

            for(TreeNode left : lefts) {
                for(TreeNode right : rights) {
                    var root = new TreeNode(rootVal);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }

        }

        return result;

    }
}

/**		Definition for a binary tree node.	 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
}

import java.util.*;

/*
	https://leetcode.com/problems/find-duplicate-subtrees/description/
*/
class FindDuplicateSubtrees {
	public static void main(String[] args) {
		var root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.right.left = new TreeNode(2);
		root.right.left.left = new TreeNode(4);

		System.out.println(new Solution().findDuplicateSubtrees(root)); // [[2,4],[4]]
	}
}


class Solution {

    private Map<String, TreeNode> map = new HashMap<>();
    private Set<TreeNode> result = new HashSet<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        postorder(root);
        return new ArrayList<>(result);
    }

    private String postorder(TreeNode node) {
        if (node == null) return "N";

        String path = postorder(node.left) + ":" + postorder(node.right) + ":" + node.val;

        if (map.containsKey(path)) {
            result.add(map.get(path));
        } else {
            map.put(path, node);
        }

        return path;
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
    TreeNode(int val) { this.val = val;}
}

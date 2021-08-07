import java.util.*;

/*
    https://leetcode.com/problems/n-ary-tree-level-order-traversal/
*/
class NaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));
        System.out.println(new Solution().levelOrder(root));
        // result : [[1],[3,2,4],[5,6]]
    }
}



class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        dfs(root, 0, result);
        return result;
    }

    private void dfs(Node node, int level, List<List<Integer>> result) {
        if (result.size() == level)
            result.add(new ArrayList<Integer>());

        result.get(level).add(node.val);

        for(Node child : node.children)
            dfs(child, level + 1, result);
    }
}

/*      Definition for a Node.  */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
        children = new ArrayList<>();
    }
}

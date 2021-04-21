import java.util.*;

/*
		https://leetcode.com/problems/n-ary-tree-preorder-traversal/
*/
class N_aryTreePreorderTraversal {
	public static void main(String[] args) {
		Node root = new Node(1);
		root.children.add(new Node(3));
		root.children.add(new Node(2));
		root.children.add(new Node(4));
		root.children.get(0).children.add(new Node(5));
		root.children.get(0).children.add(new Node(6));

		System.out.println(new Solution().preorder(root)); // [1,3,5,6,2,4]
	}
}


class Solution {

    public List<Integer> preorder(Node root) {
        List<Integer> result = new LinkedList<>();

        /*	for simple recursive solution 	*/

        // helperPreorder(root, result);
        // return result;


		/*	Iterative solution

			  Solution is pretty simple, keep inserting children of node which
			  on top of stack in reverse order i.e. right most child first so that
			  left most child comes at the top of stack.

		*/

        if (root == null) return result;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (stack.size() > 0) {
            Node node = stack.pop();

            result.add(node.val);

            /*	an inner stack is used to push children in reverse order to the stack	*/
            Stack<Node> currLevel = new Stack<>();
            for(Node child : node.children)	currLevel.add(child);
            while (currLevel.size() > 0) stack.add(currLevel.pop());

        }

        return result;
    }

    /*	helper method for recursive solution	*/
    private void helperPreorder(Node node, List<Integer> result) {
        if (node == null) return;

        result.add(node.val);

        for(Node child : node.children)
            helperPreorder(child, result);
     }
}


/*	Definition for a Node.	*/
class Node {
    public int val;
    public List<Node> children;

    public Node() {}
    public Node(int _val) {
    	val = _val;
    	children = new LinkedList<>();
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

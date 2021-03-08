import java.util.*;

/*
	https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1#
*/
class BoundaryTraversal {
	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.right.right = new Node(25);

		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		System.out.println(new Solution().printBoundary(root)); // 20 8 4 10 14 25 22
	}
}


class Solution {

	ArrayList <Integer> printBoundary(Node node) {

	    ArrayList<Integer> res = new ArrayList<>();

        res.add(node.data);

        if (node.left == null && node.right == null)
            return res;

	    if(node.left != null)
	       leftBoundary(node.left, res);

	    allLeafs(node, res);

	    if (node.right != null)
	        rightBoundary(node.right, res);

	    return res;
	}

	private void rightBoundary(Node node, ArrayList<Integer> res) {
	    if (node == null || (node.left == null && node.right == null)) return;

	    if (node.right != null)
	        rightBoundary(node.right, res);
        else
            rightBoundary(node.left, res);

        res.add(node.data);
	}

	private void allLeafs(Node node, ArrayList<Integer> res) {
	    if (node == null) {
	        //
	    } else if (node.left == null && node.right == null) {
	        res.add(node.data);
	    } else {
	        allLeafs(node.left, res);
	        allLeafs(node.right, res);
	    }
	}

	private void leftBoundary(Node node, ArrayList<Integer> res) {
	    if (node == null || (node.left == null && node.right == null)) return;

	    res.add(node.data);

	    if(node.left != null) leftBoundary(node.left, res);
	    else leftBoundary(node.right, res);

	}
}

class Node  {
    int data;
    Node left, right;
    Node(int d)  { data = d; }
}

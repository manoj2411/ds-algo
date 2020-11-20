import java.util.*;

/*
	https://www.geeksforgeeks.org/reverse-level-order-traversal/
*/
class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		// res : 4 5 2 3 1
		Solution sol = new Solution();
		System.out.println(sol.reverseLevelOrder(root));
	}
}

class Solution {
    public ArrayList<Integer> reverseLevelOrder(Node root)
    {
        if(root == null)
            return new ArrayList<Integer>();

        List<List<Integer>> levels = new ArrayList<>();
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()) {
            List<Integer> levelNodes = new LinkedList<>();
            int size = que.size();

            for(int i = 0; i < size; i++) {

                Node node = que.poll();
                levelNodes.add(node.data);

                if(node.left != null)
                    que.add(node.left);
                if(node.right != null) {
                    que.add(node.right);
                }
            }
            levels.add(levelNodes);
        }

        ArrayList<Integer> result = new ArrayList<>();
        for(int i = levels.size() - 1; i >= 0; i--) {
            result.addAll(levels.get(i));
        }
        return result;
    }
}

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}
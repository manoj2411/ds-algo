import java.util.*;
/*
	https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1#
*/
class VerticalTraversal {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.right = new Node(8);
		root.right.right = new Node(6);
		// res : 4, 2, 1, 5, 3, 8, 6
		System.out.println("res: " + verticalOrder(root));
	}

    static ArrayList<Integer> verticalOrder(Node root) {
    	if(root == null) return new ArrayList<Integer>();

        Queue<Node> que = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();

        int min = 0;
        que.add(root);
        dist.add(min);

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        while(que.size() > 0) {
        	Node node = que.remove();
        	int d = dist.remove();
        	ArrayList<Integer> list = map.getOrDefault(d, new ArrayList<Integer>());
        	list.add(node.data);
        	map.put(d, list);

        	if(node.left != null) {
        		que.add(node.left);
        		dist.add(d - 1);
        		min = Math.min(min, d - 1);
        	}

        	if(node.right != null) {
        		que.add(node.right);
        		dist.add(d + 1);
        	}
        }

        ArrayList<Integer> res = new ArrayList<>();

        while(map.containsKey(min)) {
        	res.addAll(map.get(min++));
        }

        return res;
    }
}

class Node {
	int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
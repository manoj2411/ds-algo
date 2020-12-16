import java.util.*;
/*
	https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
*/
class BottomViewBinTree {

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(5);
		root.left.right = new Node(3);
		root.left.right.left = new Node(10);
		root.right.left = new Node(4);
		root.right.left.right = new Node(14);
		root.right.right = new Node(25);

		Solution sol = new Solution();
		System.out.println("Tree bottom viewe: " + sol.bottomView(root));
		// res : 5 10 4 14 25
	}

}

class Solution {

    // Method that returns the bottom view.
    public List <Integer> bottomView(Node root) {
        Map<Integer, Integer> map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();

        que.add(root);
        dist.add(0);
        int min = 0;

        while(!que.isEmpty()) {
            Node node = que.poll();
            int d = dist.poll();
            map.put(d, node.data);

            if(node.left != null) {
                que.add(node.left);
                dist.add(d - 1);
            }
            if(node.right != null)  {
                que.add(node.right);
                dist.add(d + 1);
            }
            min = Math.min(min, d);
        }

        List<Integer> res = new ArrayList<>();

        while(map.containsKey(min)) {
            res.add(map.get(min));
            map.remove(min++);
        }

        return res;
    }
}

class Node {
    int data;
    Node left, right;
    public Node(int key) { data = key; }
}


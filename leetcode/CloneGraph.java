import java.util.*;

/*
        https://leetcode.com/problems/clone-graph/
*/

class CloneGraph {
    public static void main(String[] args) {

    }
}

class Solution {
    Node[] allnodes;
    boolean[] visited;
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;

        allnodes = new Node[101];
        visited = new boolean[101];

        for(int i = 1; i <= 100; i++)
            allnodes[i] = new Node(i);

        copy(node);

        return allnodes[node.val];
    }

    void copy(Node node) {
        visited[node.val] = true;
        Node n1 = allnodes[node.val];
        // System.out.println(node.val);

        for(Node nextNode : node.neighbors) {
            Node n2 = allnodes[nextNode.val];
            n1.neighbors.add(n2);
            if(!visited[nextNode.val])
                copy(nextNode);
        }
    }
}

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


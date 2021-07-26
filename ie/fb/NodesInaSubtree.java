import java.util.*;

class NodesInaSubtree {
	public static void main(String[] args) {
	    //Testcase 1
	    int n_1 = 3, q_1 = 1;
	    String s_1 = "aba";
	    Node root_1 = new Node(1);
	    root_1.children.add(new Node(2));
	    root_1.children.add(new Node(3));
	    ArrayList<Query> queries_1 = new ArrayList<>();
	    queries_1.add(new Query(1, 'a'));
	    int[] output_1 = new Solution().countOfNodes(root_1, queries_1, s_1);
	    int[] expected_1 = {2};
	    System.out.println(Arrays.toString(output_1)); // [2]

	    // Testcase 2
	    int n_2 = 7, q_2 = 3;
	    String s_2 = "abaacab";
	    Node root_2 = new Node(1);
	    root_2.children.add(new Node(2));
	    root_2.children.add(new Node(3));
	    root_2.children.add(new Node(7));
	    root_2.children.get(0).children.add(new Node(4));
	    root_2.children.get(0).children.add(new Node(5));
	    root_2.children.get(1).children.add(new Node(6));
	    ArrayList<Query> queries_2 = new ArrayList<>();
	    queries_2.add(new Query(1, 'a'));
	    queries_2.add(new Query(2, 'b'));
	    queries_2.add(new Query(3, 'a'));
	    int[] output_2 = new Solution().countOfNodes(root_2, queries_2, s_2);
	    System.out.println(Arrays.toString(output_2)); // [4, 1, 2]
	}
}

/*
	Build index once and then return query result in constant time
*/
class Solution {

  private void buildIndex(Node root, int[][] index, String s) {
    if (root == null) return;

    for(Node node : root.children) {

      buildIndex(node, index, s);

      for(int i = 0; i < 26; i++) {
        index[root.val][i] += index[node.val][i];
      }
    }

    int c = s.charAt(root.val - 1) - 'a';
    index[root.val][c]++;

  }


  int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
    // Write your code here

    int N = s.length();

    int[][] index = new int[N + 1][26];
    buildIndex(root, index, s);


    int[] result = new int[queries.size()];

    for(int i = 0; i < result.length; i++) {
      Query query = queries.get(i);
      result[i] = index[query.u][query.c - 'a'];
    }

    return result;

  }
}


// This is an expensive solution
class SolutionOld {

  private void fillNodes(Node[] nodes, Node root) {
    if (root == null) return;

    nodes[root.val] = root;

    for(Node n : root.children)
      fillNodes(nodes, n);

  }

  // TODO: these queries can also be cache to improve the runtime
  //  the idea is to build all chars count for every node from bottom up
  private int countNodes(Node node, char ch, String s) {
    if (node == null) return 0;

    int count = 0;
    int i = node.val - 1;

    if (s.charAt(i) == ch) count++;

    for(Node n : node.children) {
      count += countNodes(n, ch, s);
    }

    return count;
  }

  int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
    // Write your code here
    Node[] nodes = new Node[s.length() + 1];
    fillNodes(nodes, root);

    int[] result = new int[queries.size()];

    for(int i = 0; i < result.length; i++) {
      Query query = queries.get(i);
      Node node = nodes[query.u];
      result[i] = countNodes(node, query.c, s);
    }

    return result;
  }

}

// Tree Node
class Node {
    public int val;
    public List<Node> children;

    public Node() {
      val = 0;
      children = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      children = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _children) {
      val = _val;
      children = _children;
    }
}

class Query {
    int u;
    char c;
    Query(int u, char c) {
      this.u = u;
      this.c = c;
    }
}


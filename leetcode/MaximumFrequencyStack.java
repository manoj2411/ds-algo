import java.util.*;

/*
        https://leetcode.com/problems/maximum-frequency-stack/
*/

class MaximumFrequencyStack {
    public static void main(String[] args) {
        // TODO: add runner code
    }
}

class FreqStack {
    TreeSet<Node> tset;
    Map<Integer, Node> map;
    int pos;

    public FreqStack() {
        pos = 1;
        map = new HashMap<>();

        tset = new TreeSet<>((Node n1, Node n2) -> {
            if (n1.count() == n2.count())
                return -Integer.compare(n1.lastIndex(), n2.lastIndex());

            return -Integer.compare(n1.count(), n2.count());
        });

    }

    public void push(int x) {

        Node node;
        if (map.containsKey(x)) {
            node = map.get(x);
            tset.remove(node);
        } else {
            node = new Node(x);
            map.put(x, node);
        }

        node.indices.add(pos++);
        tset.add(node);
    }

    public int pop() {

        Node node = tset.pollFirst();

        node.indices.pop();

        if(node.count() > 0)
            tset.add(node);
        else
            map.remove(node.val);

        return node.val;
    }
}

class Node {

    final int val;

    Stack<Integer> indices;

    Node(int n) {
        val = n;
        indices = new Stack<>();
    }

    int count() { return indices.size(); }
    int lastIndex() { return indices.peek(); }

}
/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */

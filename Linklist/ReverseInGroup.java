class ReverseInGroup {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(7);
		head.next.next.next.next.next.next.next = new Node(8);
		System.out.print("List : ");
		printList(head);

		int k = 3;
		head = reverse(head, k);
		System.out.print("\nReversed by ("+ k +") : ");
		printList(head);

	}

    public static Node reverse(Node node, int k) {
        if(node == null || node.next == null)
            return node;

        /*
            1 2 3 4 5 6 7 8
                ^
        */
        Node curr = node;
        for(int i = 1; i < k && curr != null; i++) {
            curr = curr.next;
        }

        Node next = null;
        if(curr != null) {
            next = curr.next;
            curr.next = null;
        }

        Node head = reverse(node);
        node.next = reverse(next, k);

        return head;

    }

    static Node reverse(Node node) {
        if(node == null || node.next == null)
            return node;

        Node head = reverse(node.next);
        node.next.next = node;
        node.next = null;

        return head;
    }

    static void printList(Node head) {
    	while(head != null) {
    		System.out.print(head.data + " ");
    		head = head.next;
    	}
    	System.out.println();
    }
}

class Node {
    int data;
    Node next;
    Node(int key) { data = key; }
}
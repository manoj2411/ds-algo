/*
	https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1
*/
class MergeKsortedLinkedLists {
	public static void main(String[] args) {
		Node[] arr = new Node[3];
		arr[0] = new Node(3);
		arr[1] = new Node(4);
		arr[1].next = new Node(6);
		arr[1].next.next = new Node(8);
		arr[2] = new Node(1);
		arr[2].next = new Node(5);

		Node result = new Solution().mergeKList(arr, arr.length);

		printLinkedList(result);
	}

	static void printLinkedList(Node head) {
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}

class Solution {
    Node mergeKList(Node[]a, int N) {
        int r = N - 1;

        while(r > 0) {

            for(int l = 0; l < r; l++) {
                a[l] = merge(a[l], a[r--]);
            }
        }

        return a[r];
    }

    Node merge(Node n1, Node n2) {
        Node dummy = new Node(-1);
        Node curr = dummy;

        while(n1 != null && n2 != null) {
            if(n1.data <= n2.data) {
                curr.next = n1;
                n1 = n1.next;
            } else {
                curr.next = n2;
                n2 = n2.next;
            }
            curr = curr.next;
        }

        curr.next = (n1 == null) ? n2 : n1;

        return dummy.next;
    }
}

class Node {
    int data;
    Node next;
    Node(int key) { data = key; }
}

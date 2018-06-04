package geeksforgeeks.linklist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkList {
	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static boolean isEmpty(Node head) {
		return head == null;
	}

	private static Node newHead;

	private static void reverse(Node head) {
		if (head.next == null) {
			newHead = head;
			return;
		}
		reverseList(head.next);
		head.next.next = head;
	}

	public static Node reverseList(Node head) {
		if (isEmpty(head))
			return head;

		reverse(head);
		head.next = null;
		return newHead;
	}

	public static Node kReverseList(int k, Node head) {
		int i = 0;
		Node x = head;
		if (x == null) {
			
		}
		Node y = x.next;
		if (y == null)
			return x;
		Node z = x.next.next;
		while (i < k - 1) {
			y.next = x;
			if (z == null) {
				head.next = null;
				return y;
			}
			x = y;
			y = z;
			z = z.next;
			i++;
		}
		head.next = kReverseList(k, y);
		return x;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String arr[] = s.split(" ");
		Node head = new Node(new Integer(arr[0]));
		Node temp = head;
		for (int i = 1; i < arr.length; i++) {
			temp.next = new Node(new Integer(arr[i]));
			temp = temp.next;
		}
		printList(head);
		head = reverseList(head);
		printList(head);
		int k=4;
		head = kReverseList(6, head);
		printList(head);
	}
}

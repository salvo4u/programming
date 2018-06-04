package geeksforgeeks.linklist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class CircularLinkList {
	public static void displayList(Node head) {
		Node node = head;
		System.out.print(node.data + " ");
		node = node.next;
		while (node != head) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static Node sortedInsert(Node head, int ele) {
		Node temp = head, prev = null;
		Node n = new Node(ele);
		do {
			prev = temp;
			temp = temp.next;
			if (prev.data < ele && ele < temp.data)
				break;
			if (prev.data > ele && ele < temp.data && prev.data > temp.data)
				break;
		} while (temp != head);
		prev.next = n;
		n.next = temp;
		return head;
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String arr[] = s.split(" ");
		int i = 0;
		Node head = new Node(new Integer(arr[0]));
		Node temp = head;
		for (i = 1; i < arr.length - 1; i++) {
			temp.next = new Node(new Integer(arr[i]));
			temp = temp.next;
		}
		temp.next = new Node(new Integer(arr[i]));
		temp.next.next = head;
		displayList(head);
		displayList(sortedInsert(head, 9));
		ArrayList<Integer> alist = new ArrayList<Integer>();
		alist.add(1);
		alist.add(11);
		alist.add(111);
		alist.add(1111);
		alist.add(11111);

	}
}

package geeksforgeeks.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class LinkListNode {
	LinkListNode next, prev;
	int data;
	public LinkListNode(int data) {
		this.data = data;
	}
}

class MyLinkList {
	LinkListNode head, tail;
}

public class Tree {
	public static TreeNode getRandomTree() {
		TreeNode mainroot = new TreeNode(7);
		TreeNode root = mainroot;
		root.left = new TreeNode(5);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(6);
		root.left.right = new TreeNode(40);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(14);
		return mainroot;
	}

	public static TreeNode getRandomBST() {
		TreeNode mainroot = new TreeNode(7);
		TreeNode root = mainroot;
		root.left = new TreeNode(5);
		root.right = new TreeNode(12);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(2);

		root.left.right = new TreeNode(6);
		root.left.left.right = new TreeNode(4);
		root.right.left = new TreeNode(10);
		root.right.right = new TreeNode(14);
		root.right.right.left = new TreeNode(13);
		root.right.right.right = new TreeNode(140);
		
		return mainroot;
	}

	public static void insertToBST(TreeNode root, int ele) {
		if (ele < root.data) {
			if (root.left == null) {
				root.left = new TreeNode(ele);
				return;
			} else
				insertToBST(root.left, ele);
		} else {
			if (root.right == null) {
				root.right = new TreeNode(ele);
				return;
			} else
				insertToBST(root.right, ele);
		}
	}

	public static void inOrder(TreeNode node) {
		if (node == null)
			return;
		inOrder(node.left);
		System.out.print(node.data + "  ");
		inOrder(node.right);
	}

	public static void preOrder(TreeNode node) {
		if (node == null)
			return;
		System.out.print(node.data + "  ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public static void postOrder(TreeNode node) {
		if (node == null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + "  ");
	}

	public static int getRighttMin(TreeNode node) {
		if (node.right == null)
			return node.data;
		node = node.right;
		while (node.left != null)
			node = node.left;
		return node.data;
	}

	public static int getLeftMax(TreeNode node) {
		if (node.left == null)
			return node.data;
		node = node.left;
		while (node.right != null)
			node = node.right;
		return node.data;
	}

	public static boolean isBST(TreeNode node) {
		if (node.data >= getLeftMax(node) && node.data <= getRighttMin(node)) {
			boolean left = true;
			boolean right = true;

			if (node.left != null)
				left = isBST(node.left);
			if (node.right != null)
				right = isBST(node.right);
			return left && right;
		}
		return false;
	}

	/*
	 * This function needs changes its not working
	 */
	public static boolean isBSTOptimized(TreeNode node, int MAX, int MIN) {

		if (node == null)
			return true;

		if (node.data > MAX && node.data < MIN)
			return false;

		boolean left = false, right = false;
		if (node.data < MAX && node.data > MIN) {
			left = isBSTOptimized(node.left, node.data - 1, MIN);
			right = isBSTOptimized(node.right, MAX, node.data + 1);
		}
		return left && right;
	}

	public static int getrootPos(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left != null)
			return getrootPos(root.left) + getrootPos(root.left.right) + 1;
		return getrootPos(root.left) + 1;
	}

	// http://www.geeksforgeeks.org/archives/10379
	public static int getKthSmallest(TreeNode root, int k) {
		int rootpos = getrootPos(root);
		if (rootpos == k)
			return root.data;

		if (rootpos > k)
			return getKthSmallest(root.left, k);
		return getKthSmallest(root.right, k - rootpos);
	}

	// http://www.geeksforgeeks.org/archives/18722
	public static int getMaximumLeafPath(TreeNode root, int currsum, int maxsum) {
		if (root == null)
			return maxsum;

		if (root.left == null && root.right == null) {
			currsum += root.data;
			if (maxsum < currsum)
				maxsum = currsum;
			return maxsum;
		}
		int leftsum = 0, rightsum = 0;
		if (root.left != null)
			leftsum = getMaximumLeafPath(root.left, currsum + root.data, maxsum);
		if (root.right != null)
			rightsum = getMaximumLeafPath(root.right, currsum + root.data,
					maxsum);
		return leftsum > rightsum ? leftsum : rightsum;
	}

	// http://www.geeksforgeeks.org/archives/17138
	public static TreeNode bstFromSortedArray(int arr[], int start, int end) {
		if (start == end)
			return new TreeNode(arr[start]);
		int mid = (start + end) / 2;
		TreeNode node = new TreeNode(arr[mid]);
		node.left = bstFromSortedArray(arr, start, mid - 1);
		node.right = bstFromSortedArray(arr, mid + 1, end);
		return node;
	}

	// http://www.geeksforgeeks.org/archives/16952
	public static void nextLevelNode(TreeNode root) {

	}

	// http://www.geeksforgeeks.org/archives/17855
	public static int sumTree(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			int temp = root.data;
			return temp;
		}
		int left = 0, right = 0;
		if (root.left != null)
			left = sumTree(root.left);

		if (root.right != null)
			right = sumTree(root.right);

		return root.data + right + left;
	}

	public static void zigZag(TreeNode node) {
		int direction = 1;
		ArrayList<TreeNode> alist = new ArrayList<TreeNode>();
		alist.add(node);
		int count1 = 1;
		int count2 = 0;
		while (alist.size() > 0) {
			if (direction == 1) {
				for (int i = 0; i < count1; i++) {
					TreeNode n = alist.get(i);
					if (n.left != null) {
						count2++;
						alist.add(n.left);
					}
					if (n.right != null) {
						count2++;
						alist.add(n.right);
					}

				}
				for (int i = 0; i < count1; i++) {
					System.out.print(alist.get(0).data + " ");
					alist.remove(0);
				}
				count1 = 0;
			} else {
				int pos2 = alist.size() - 1;
				int pos1 = alist.size() - count2;
				for (int i = pos1; i <= pos2; i++) {
					TreeNode n = alist.get(i);
					if (n.left != null) {
						count1++;
						alist.add(n.left);
					}
					if (n.right != null) {
						count1++;
						alist.add(n.right);
					}
				}

				for (int i = pos2; i >= pos1; i--) {
					System.out.print(alist.get(i).data + " ");
					alist.remove(i);
				}
				count2 = 0;
			}
			direction = direction ^ 1;
		}
	}

	static TreeNode next;

	// http://www.geeksforgeeks.org/archives/17358
	public static void inorderSuccersor(TreeNode root) {
		if (root != null) {
			inorderSuccersor(root.right);
			root.next = next;
			next = root;
			inorderSuccersor(root.left);
		}
	}

	public static int LCA(TreeNode root, int n1, int n2) {
		if (root.data >= n1 && root.data <= n2)
			return root.data;
		if (root.data <= n1 && root.data >= n2)
			return root.data;
		if (root.data > n1 && root.data > n2)
			return LCA(root.left, n1, n2);

		return LCA(root.right, n1, n2);
	}

	public static TreeNode createTreeFromConsole() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String arr[] = s.split(" ");
		int[] intarr = new int[arr.length];
		TreeNode root = new TreeNode(new Integer(arr[0]));
		intarr[0] = new Integer(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			intarr[i] = new Integer(arr[i]);
			insertToBST(root, intarr[i]);
		}
		return root;
	}

	public static MyLinkList getLinkList(TreeNode node) {
		if (node == null)
			return null;
		if (node.left == null && node.right == null) {
			LinkListNode n = new LinkListNode(node.data);
			MyLinkList my = new MyLinkList();
			my.head = n;
			my.tail = n;
			return my;
		}
		MyLinkList lll = getLinkList(node.left);
		MyLinkList rll = getLinkList(node.right);
		LinkListNode nn = new LinkListNode(node.data);
		if (lll != null) {
			nn.prev = lll.tail;
			lll.tail.next = nn;
		}
		if (rll != null) {
			nn.next = rll.head;
			rll.head.prev = nn;
		}
		if (lll != null && rll != null)
			lll.tail = rll.tail;
		return lll != null ? lll : rll;
	}

	public static void main(String args[]) throws IOException {
		TreeNode bst = getRandomBST();
		// zigZag(bst);
		System.out.println();
		MyLinkList ln = getLinkList(bst);

		while (ln.head != null) {
			System.out.print(ln.head.data + "  ");
			ln.head = ln.head.next;
		}
		System.out.println();
		while (ln.tail != null) {
			System.out.print(ln.tail.data + "  ");
			ln.tail = ln.tail.prev;
		}
	}
}

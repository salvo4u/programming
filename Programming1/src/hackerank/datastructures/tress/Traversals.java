package hackerank.datastructures.tress;

//https://www.hackerrank.com/challenges/binary-search-tree-insertion/problem
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

class Node {
	int data;
	Node left;
	Node right;
}

class MapEntry {
	int nodeValue;
	int nodeLevel;
	public MapEntry(int value, int level) {
		nodeValue = value;
		nodeLevel = level;
	}
}

class Tree {
	ArrayList<Node> q = new ArrayList<Node>();

	static boolean isLeaf(Node root) {
		return root.right == null && root.left == null;
	}

	static int height(Node root) {
		if (root == null)
			return 0;
		if (isLeaf(root))
			return 0;
		int lh = height(root.left);
		int rh = height(root.right);
		return (lh > rh ? lh : rh) + 1;
	}

	void levelOrder(Node root) {

		do {

			System.out.print(root.data + " ");
			if (root.left != null)
				q.add(root.left);
			if (root.right != null)
				q.add(root.right);
			root = q.remove(0);
		} while (q.size() != 0);
	}
	
	static Node Insert(Node root, int value) {
		if (root == null) {
			Node n = new Node();
			n.data = value;
			return n;
		}
		if (value <= root.data) {
			Node n = Insert(root.left, value);
			root.left = n;

		} else {
			Node n = Insert(root.right, value);
			root.right = n;
		}
		return root;
	}

	void initializeQTree(Node root, int dist, int level) {
		if (root == null)
			return;
		if (map.get(dist) == null) {
			MapEntry nodeEntry = new MapEntry(root.data, level);
			map.put(dist, nodeEntry);
		} else {
			MapEntry nodeEntry = (MapEntry) map.get(dist);
			if (level <= nodeEntry.nodeLevel) {
				map.put(dist, new MapEntry(root.data, level));
			}
		}
		initializeQTree(root.left, dist - 1, level + 1);
		initializeQTree(root.right, dist + 1, level + 1);
	}
	TreeMap<Integer, MapEntry> map = new TreeMap<Integer, MapEntry>();
	//https://www.hackerrank.com/challenges/tree-top-view/problem
	
	static HashMap <Integer,HashSet<Integer>> graph = new HashMap<Integer,HashSet<Integer>>();
	static HashMap <String,Integer> distance = new HashMap<String,Integer>();
	static void getDistanceBetweenNodes(int n1,int n2,int last,int dist){
		HashSet<Integer> set = graph.get(n1);
		if(distance.get(n1+" "+n2)!=null)
			return;
		if(set.contains(n2)){//n1 is connected to n2
			distance.put(n1+" "+n2, dist+1);
			distance.put(n2+" "+n1, dist+1);
			return;
		}
		if(set.size() == 1)
		{
			distance.put(n1+" "+n2, dist);
			distance.put(n2+" "+n1, dist);
			return ;
		}
		//if n1 is not connected to n2 iterate over the connected list of n1
		last = n1;
		for (Iterator<Integer> iterator = set.iterator(); iterator.hasNext();) {
			Integer node = (Integer) iterator.next();
			getDistanceBetweenNodes(node, n2, last, dist+1);	
		}
	}
	
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(2);
		hs.add(3);
		hs.add(4);
		graph.put(1,hs);
		
		hs = new HashSet<Integer>();
		hs.add(7);
		hs.add(1);
		hs.add(5);
		hs.add(6);
		graph.put(3,hs);
		
		hs = new HashSet<Integer>();
		hs.add(3);
		graph.put(7,hs);
		
		hs = new HashSet<Integer>();
		hs.add(1);
		graph.put(2,hs);
		
		hs = new HashSet<Integer>();
		hs.add(1);
		graph.put(4,hs);
		
		hs = new HashSet<Integer>();
		hs.add(3);
		graph.put(5,hs);
		
		hs = new HashSet<Integer>();
		hs.add(3);
		graph.put(6,hs);
		
		
		getDistanceBetweenNodes(2, 7, 2, 0);
		
		
		
	}
}

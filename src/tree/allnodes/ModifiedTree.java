package tree.allnodes;




import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	String label;
	List<Node> list;
}

class ModifiedTree {
	/*
	 * Using a Breadth First Traversal search for traversal
	 */
	public List<Node> traverseTreeAndReturnListContainingAllNodes(Node n) {
		List<Node> treelist = new ArrayList<Node>();//The tree list to be returned
		Queue<Node> queue = new LinkedList<Node>();//The queue for the BFS

		if (n == null)
			return treelist;

		queue.add(n);//using BFS search
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			treelist.add(node);
			if (node.list != null) {
				for (int i = 0; i < node.list.size(); i++)
					queue.add(node.list.get(i));
			}
		}
		return treelist;
	}

	public Node createTree1() {
		Node node1 = new Node();
		node1.label = "1";

		Node node2 = new Node();
		node2.label = "2";

		Node node3 = new Node();
		node3.label = "3";

		Node node4 = new Node();
		node4.label = "4";

		Node node5 = new Node();
		node5.label = "5";

		Node node6 = new Node();
		node6.label = "6";

		Node node7 = new Node();
		node7.label = "7";

		Node node8 = new Node();
		node8.label = "8";

		Node node9 = new Node();
		node9.label = "9";

		List<Node> list1 = new ArrayList<Node>();
		list1.add(node2);
		list1.add(node3);
		list1.add(node4);

		List<Node> list2 = new ArrayList<Node>();
		list2.add(node5);

		List<Node> list4 = new ArrayList<Node>();
		list4.add(node6);
		list4.add(node7);

		List<Node> list5 = new ArrayList<Node>();
		list5.add(node8);

		List<Node> list7 = new ArrayList<Node>();
		list7.add(node9);
		node1.list = list1;
		node2.list = list2;
		node4.list = list4;
		node5.list = list5;
		node7.list = list7;
		return node1;
	}
	public Node createTree2()
	{
		Node node1 = new Node();
		node1.label = "1";

		Node node2 = new Node();
		node2.label = "2";

		Node node3 = new Node();
		node3.label = "3";

		Node node4 = new Node();
		node4.label = "4";

		Node node5 = new Node();
		node5.label = "5";

		List<Node> list1 = new ArrayList<Node>();
		list1.add(node2);
		list1.add(node3);

		List<Node> list2 = new ArrayList<Node>();
		list2.add(node4);

		List<Node> list3 = new ArrayList<Node>();
		list3.add(node5);

		node1.list = list1;
		node2.list = list2;
		node3.list = list3;
		
		return node1;
	}
	public Node createTree3()
	{
		Node node1 = new Node();
		node1.label = "1";

		Node node2 = new Node();
		node2.label = "2";

		Node node3 = new Node();
		node3.label = "3";
		List<Node> list1 = new ArrayList<Node>();
		list1.add(node2);

		List<Node> list2 = new ArrayList<Node>();
		list2.add(node3);


		node1.list = list1;
		node2.list = list2;
		
		return node1;
	}
	public Node createTree4()
	{
		Node node1 = new Node();
		node1.label = "1";


		return node1;
	}

	public void printList(List<Node> list)
	{
		for(int i=0;i<list.size();i++)
		{
			System.out.print(list.get(i).label+"  ");
		}
	}
	public static void main(String[] args) {
		ModifiedTree mt = new ModifiedTree();
		Node root = mt.createTree4();
		mt.printList(mt.traverseTreeAndReturnListContainingAllNodes(root));
	}
}

package random;

class TrieNode {
	boolean isWord;
	char ch;
	TrieNode arr[] = new TrieNode[26];
}

public class Tries {
	private TrieNode root;

	public void setTrieRoot(TrieNode root) {
		this.root = root;
	}

	public TrieNode getTrieRoot() {
		return this.root;
	}

	private boolean searchWord(TrieNode node, String word, int i) {
		int index = word.charAt(i) - 'a';
		TrieNode tnode = node.arr[index];
		if (tnode == null)
			return false;
		if (tnode.ch == word.charAt(i)) {
			if (!tnode.isWord)
				return searchWord(tnode, word, i + 1);
			if (tnode.isWord)
				if(i == word.length() - 1)
					return true;
				else
					return searchWord(tnode, word, i + 1);
		}
		return false;
	}

	private void insertWord(TrieNode root, String word, int i) {
		int index = word.charAt(i) - 'a';
		TrieNode tnode = root.arr[index];
		if (tnode == null) {
			tnode = new TrieNode();
			tnode.ch = word.charAt(i);
			root.arr[index] = tnode;
			if (i == word.length() - 1) {
				tnode.isWord = true;
				return;
			}
		}
		insertWord(tnode, word, i + 1);
	}

	public void insert(String word) {
		insertWord(root, word, 0);
	}

	public boolean search(String word) {
		return searchWord(root, word, 0);
	}

	private void printTrie(TrieNode root) {
		for (int i = 0; i < root.arr.length; i++) {
			if (root.arr[i] != null) {
				System.out.print(root.arr[i].ch);
				if (root.arr[i].isWord)
					System.out.println();
				printTrie(root.arr[i]);
			}
		}
	}

	public void print() {
		printTrie(root);
	}

	public static void main(String[] args) {
		Tries trie = new Tries();
		TrieNode root = new TrieNode();
		trie.setTrieRoot(root);
		trie.insert("bat");
		trie.insert("bot");
		trie.insert("bots");
		
		trie.print();
		System.out.println(trie.search("bots"));
	}
}

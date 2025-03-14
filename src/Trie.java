public class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode(' ');
	}

	public void insert(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char offSet = Character.isUpperCase(word.charAt(i)) ? 'A' : 'a';
			current.children[word.charAt(i) - offSet] = new TrieNode(word.charAt(i));
			current = current.children[word.charAt(i) - offSet];
		}
	}

	public boolean search(String word) {
		TrieNode current = root;
		for (int i = 0; i < word.length(); i++) {
			char offSet = Character.isUpperCase(word.charAt(i)) ? 'A' : 'a';
			if (current.children[word.charAt(i) - offSet] == null) {
				return false;
			} else {
				current = current.children[word.charAt(i) - offSet];
			}
		}
		return true;
	}
}
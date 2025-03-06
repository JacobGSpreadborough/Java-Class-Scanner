public class TrieNode {
    char key;
    TrieNode[] children = new TrieNode[52];
    boolean isFinalCharacter;

    public TrieNode(char key) {
        this.key = key;
    }

}

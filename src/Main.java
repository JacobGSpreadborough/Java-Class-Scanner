public class Main {
    public static void main(String[] args) {

        Trie words = new Trie();
        words.insert("Hello");

        System.out.println(words.search("Hello"));
    }
}
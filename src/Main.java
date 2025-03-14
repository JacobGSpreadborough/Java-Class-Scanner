import java.io.File;
import java.io.FileNotFoundException;
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/Trie.java");
        ClassScanner classScanner = new ClassScanner(file);
        System.out.println(classScanner.accessModifiers.search("public"));
        
    }
}
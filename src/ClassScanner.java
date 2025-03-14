import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class ClassScanner {
    Scanner scanner;
    Trie classAccessModifiers = new Trie();
    Trie classModifiers = new Trie();
    Trie accessModifiers = new Trie();
    Trie modifiers = new Trie();

    public enum Type {
        CLASS,
        METHOD,
        FIELD,
        CONSTRUCTOR,
    }

    public static class Element {
        // only 1 access modifier per element
        String accessModifier;
        String[] modifiers = new String[0];
        Type type;
    }

    public void checkAccessModifier(Element element) {
        String word = scanner.next();
        System.out.println("Checking access modifier: " + word);
        if (accessModifiers.search(word)) {
            System.out.println("Access modifier found");
            element.accessModifier = word;
        }
        else{
            System.out.println("Access modifier not found");
        }
    }

    public void checkModifiers(Element element) {
        String word = scanner.next();
        int i = 0;
        while (modifiers.search(word)) {
            element.modifiers[i] = word;
            word = scanner.next();
            i++;
        }
    }

    public void getElementType(Element element) {
        String word = scanner.next();
        switch (word) {
            case "class":
                element.type = Type.CLASS;
                break;
            case "method":
                element.type = Type.METHOD;
                break;
            case "field":
                element.type = Type.FIELD;
                break;
            case "constructor":
                element.type = Type.CONSTRUCTOR;
                break;
            default:
                break;
        }
    }

    public void skipComments(){
        String word = scanner.next();
        if(Objects.equals(word, "//")){
            scanner.nextLine();
            skipComments();
        }
    }

    public void scan() {
        Element element = new Element();
        checkAccessModifier(element);
        checkModifiers(element);
        getElementType(element);
        System.out.println("Access modifiers: " + element.accessModifier);
        System.out.println("Modifiers: " + Arrays.toString(element.modifiers));
        System.out.println("Type: " + element.type);
    }


    public ClassScanner(File file) throws FileNotFoundException {
        classAccessModifiers.insert("public");
        classModifiers.insertArray(new String[]{"final", "abstract"});
        accessModifiers.insertArray(new String[]{"public", "private", "protected"});
        modifiers.insertArray(new String[]{"static", "final", "abstract", "transient", "volatile", "synchronized"});
        scanner = new Scanner(file);
    }


}

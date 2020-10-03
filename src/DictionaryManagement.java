import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DictionaryManagement extends Dictionary {


    public static void insertFromCommandline() {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        System.out.println("Enter number of words:");
        // number of words
        int n = sc.nextInt();
        System.out.println("Enter words:");
        for (int i = 0; i < n; i++) {
            String eng = sc.next();
            String vie = sc.nextLine();
            addWord(eng, vie);
        }

    }


    public static void insertFromFile() throws java.io.IOException {
        File file = new File("dictionaries.txt");
        Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
        while (sc.hasNextLine()) {
            String eng = sc.next();
            String vie = sc.nextLine();
            addWord(eng, vie);
        }

    }

    public static void dictionaryLookup() {
        System.out.println("Nhap tu can tra:");
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        String EngWord = sc.next();
        boolean found = false;
        for (int i = 0; i < getDictSize(); i++) {
            if (EngWord.equals(getWord(i).getWordTarget())) {
                showWord(i);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay!");
        }
    }
}

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
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
        Collections.sort(words);
    }


    public static void insertFromFile() throws java.io.IOException {
        File file = new File("dictionaries.txt");
        Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
        while (sc.hasNextLine()) {
            String eng = sc.next();
            String vie = sc.nextLine();
            addWord(eng, vie);
        }
        Collections.sort(words);
    }

    public static void insertFromFile(String filename) throws java.io.IOException {
        File file = new File(filename);
        Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
        while (sc.hasNextLine()) {
            String eng = sc.next();
            String vie = sc.nextLine();
            addWord(eng, vie);
        }
        Collections.sort(words);
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

    public static String dictionaryLookup(String EngWord) {
        String wordExplain = "Không tìm thấy";
        boolean found = false;
        for (int i = 0; i < getDictSize(); i++) {
            if (EngWord.equals(getWord(i).getWordTarget())) {
                wordExplain = getWord(i).getWordExplain();
                found = true;
            }
        }

        return wordExplain;
    }

    public static void editFromCommandLine() {
        System.out.println("Nhap tu can sua:");
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        String EngWord = sc.next();
        boolean found = false;
        int index = 0;
        for (int i = 0; i < getDictSize(); i++) {
            if (EngWord.equals(getWord(i).getWordTarget())) {
                found = true;
                index = i;
                break;

            }
        }
        if (!found) {
            System.out.println("Khong tim thay tu can sua!");
        }
        if (found) {
            System.out.println("Nhap nghia moi cua tu can sua:");
            sc.nextLine();
            getWord(index).setWordExplain(sc.nextLine());
        }

    }

    public static void removeFromCommandLine() {
        System.out.println("Nhap tu can xoa:");
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        String EngWord = sc.next();
        boolean found = false;
        int index = 0;
        for (int i = 0; i < getDictSize(); i++) {
            if (EngWord.equals(getWord(i).getWordTarget())) {
                found = true;
                index = i;
                break;

            }
        }
        if (!found) {
            System.out.println("Khong tim thay tu can xoa!");
        } else {
            words.remove(index);
        }

    }

    public static void searchFromCommandLine() {
        System.out.println("Nhap tu can tra:");
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        String EngWord = sc.next();
        boolean found = false;
        for (int i = 0; i < getDictSize(); i++) {
            if (getWord(i).getWordTarget().startsWith(EngWord)) {
                showWord(i);
                found = true;

            }
        }
        if (!found) {
            System.out.println("Khong tim thay tu can tra!");
        }
    }
}

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

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
        File file = new File("500word.txt");
        Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
        sc.useDelimiter(",");
        while (sc.hasNextLine()) {
            String eng = sc.next();
            String vie = sc.nextLine().substring(1);
            addWord(eng, vie);
        }
    }

    public static void insertFromFile(String filename) throws java.io.IOException {
        File file = new File(filename);
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
        if (words.containsKey(EngWord)) {
            System.out.println(showWord(EngWord));
        } else {
            System.out.println("Khong tim thay!");
        }

    }

    public static String dictionaryLookup(String EngWord) {
        String wordExplain = "Không tìm thấy";
        if (words.containsKey(EngWord)) {
            wordExplain = words.get(EngWord).getWordExplain();
        }


        return wordExplain;
    }

    public static boolean dictionaryCheckIfExist(String EngWord) {
        return words.containsKey(EngWord);
    }

    public static void editFromCommandLine() {
        System.out.println("Nhap tu can sua:");
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        String EngWord = sc.next();
        boolean found = dictionaryCheckIfExist(EngWord);
        if (!found) {
            System.out.println("Khong tim thay tu can sua!");
        }
        if (found) {
            System.out.println("Nhap nghia moi cua tu can sua:");
            sc.nextLine();
            getWord(EngWord).setWordExplain(sc.nextLine());
        }

    }

    public static void removeFromCommandLine() {
        System.out.println("Nhap tu can xoa:");
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        String EngWord = sc.next();
        boolean found = dictionaryCheckIfExist(EngWord);

        if (!found) {
            System.out.println("Khong tim thay tu can xoa!");
        } else {
            words.remove(EngWord);
        }

    }

    public static void searchFromCommandLine() {
        System.out.println("Nhap tu can tra:");
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        String EngWord = sc.next();
        Set<String> keySet = words.keySet();
        for (String key : keySet) {
            if (key.startsWith(EngWord))
                System.out.println(showWord(key));
        }
    }

    public static void getResource(String path) {

    }

}

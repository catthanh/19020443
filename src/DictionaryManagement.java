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

    
}

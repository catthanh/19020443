import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class DictionaryCommandline extends DictionaryManagement {
    public static void showAllWords() {
        System.out.println("No\t| English\t| Vietnamese");

        for (int i = 0; i < getDictSize(); i++) {
            showWord(i);
        }

    }

    enum Phase {
        MENU,
        ADD,
        SHOW,
        LOOKUP,
        READ_FILE,
    }

    public static void dictionaryBasic() {
        boolean running = true;
        Phase appPhase = Phase.MENU;

        while (running) {
            switch (appPhase) {
                default: {
                    System.out.println("Input 'i' to add words");
                    System.out.println("Input 's' to show all words");
                    System.out.println("Input 'x' to exit");
                    Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
                    char c = sc.next().charAt(0);
                    switch (c) {
                        case 'i': {
                            appPhase = Phase.ADD;
                            break;
                        }
                        case 's': {
                            appPhase = Phase.SHOW;
                            break;
                        }
                        case 'x': {
                            running = false;
                            break;
                        }
                        default: {
                            appPhase = Phase.MENU;
                            break;
                        }
                    }

                    break;
                }
                case ADD: {
                    System.out.println("Add new words:");
                    insertFromCommandline();
                    appPhase = Phase.MENU;

                    break;
                }
                case SHOW: {
                    showAllWords();
                    appPhase = Phase.MENU;
                    break;
                }
            }
            //clrscr();


        }
//        DictionaryManagement.insertFromCommandline(dict);
//        showAllWords(dict);

    }

    
    public static void main(String[] args) throws Exception {
        dictionaryBasic();
    }
}

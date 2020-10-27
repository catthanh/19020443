import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.Set;

public class DictionaryCommandline extends DictionaryManagement {
    public static void showAllWords() {
        System.out.println("No\t| English\t| Vietnamese");

        Set<String> keySet = words.keySet();
        for (String key : keySet) {
            System.out.println(showWord(key));
        }

    }

    enum Phase {
        MENU,
        ADD,
        SHOW,
        LOOKUP,
        READ_FILE,
        EDIT,
        REMOVE,
        SEARCH
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

    public static void dictionaryAdvanced() throws Exception {

        boolean running = true;
        boolean menu = true;
        Phase appPhase = Phase.MENU;

        while (running) {
            switch (appPhase) {
                case MENU: {
                    System.out.println("Input 'i' to add word");
                    System.out.println("Input 's' to show all words");
                    System.out.println("Input 'l' to look up word");
                    System.out.println("Input 'r' to read from file");
                    System.out.println("Input 'x' to exit");
                    System.out.println("Input 'e' to edit words");
                    System.out.println("Input 'd' to remove words");
                    System.out.println("Input 'f' to search words");
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
                        case 'l': {
                            appPhase = Phase.LOOKUP;
                            break;
                        }
                        case 'r': {
                            appPhase = Phase.READ_FILE;
                            break;
                        }
                        case 'x': {
                            running = false;
                            break;
                        }
                        case 'd': {
                            appPhase = Phase.REMOVE;
                            break;
                        }
                        case 'e': {
                            appPhase = Phase.EDIT;
                            break;
                        }
                        case 'f': {
                            appPhase = Phase.SEARCH;
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
                case LOOKUP: {
                    dictionaryLookup();
                    appPhase = Phase.MENU;
                    break;
                }
                case READ_FILE: {
                    insertFromFile();
                    appPhase = Phase.MENU;
                    break;
                }
                case EDIT: {
                    editFromCommandLine();
                    appPhase = Phase.MENU;
                    break;
                }
                case REMOVE: {
                    removeFromCommandLine();
                    appPhase = Phase.MENU;
                    break;
                }
                case SEARCH: {
                    searchFromCommandLine();
                    appPhase = Phase.MENU;
                    break;
                }
            }


        }
    }


    public static void main(String[] args) throws Exception {
        dictionaryAdvanced();
    }
}

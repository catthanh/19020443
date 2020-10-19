import java.util.ArrayList;

public class Dictionary {
    protected static final ArrayList<Word> words = new ArrayList<>();


    public Dictionary() {

    }

    public static int getDictSize() {
        return words.size();
    }

    public static void addWord(String eng, String vie) {
        Word word = new Word(eng, vie);
        words.add(word);

    }

    public static Word getWord(int i) {
        return words.get(i);
    }

    public static void showWord(int i) {
        System.out.println(i + 1 + "\t| " + words.get(i).getWordTarget() + "\t| " + words.get(i).getWordExplain());
    }

}

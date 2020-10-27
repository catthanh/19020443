import java.util.TreeMap;

public class Dictionary {
    protected static final TreeMap<String, Word> words = new TreeMap<>();


    public Dictionary() {

    }

    public static int getDictSize() {
        return words.size();
    }

    public static void addWord(String eng, String vie) {
        Word word = new Word(eng, vie);
        words.put(eng, word);

    }

    public static Word getWord(String i) {
        return words.get(i);
    }

    public static String showWord(String i) {
        return (i + 1 + "\t| " + words.get(i).getWordTarget() + "\t| " + words.get(i).getWordExplain());
    }

}

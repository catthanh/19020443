public class Word implements Comparable<Word> {
    private String wordTarget;
    private String pronunciation = "";
    private String wordExplain;


    public Word(String eng, String vie) {
        this.wordTarget = eng;
        this.wordExplain = vie;

    }

    public String getWordTarget() {
        return wordTarget;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public String getWordExplain() {
        return wordExplain;
    }

    @Override
    public int compareTo(Word o) {
        return wordTarget.compareTo(o.wordTarget);
    }

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    @Override
    public String toString() {
        return wordTarget;
    }
}

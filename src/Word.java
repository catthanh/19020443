public class Word {
    private String wordTarget;
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

    public void setWordExplain(String wordExplain) {
        this.wordExplain = wordExplain;
    }
}

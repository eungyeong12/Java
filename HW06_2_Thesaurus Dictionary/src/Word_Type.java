public class Word_Type {
    private String word;
    private String type;

    public Word_Type(String keyWord, String type) {
        this.word = keyWord;
        this.type = type;
    }

    public String toString() {
        return word + "_" + type;
    }

}

import java.util.ArrayList;

public class Thesaurus {
    private String keyword;
    private String type;
    private ArrayList<String> list_thesaurus = new ArrayList<>(); // 유의어

    public void setKeyWord(String keyWord) {
        this.keyword = keyWord;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void addThesaurus(String word) {
        list_thesaurus.add(word);
    }

    public String toString() {
        return keyword + " [" + type + "] : " + list_thesaurus;
    }
}

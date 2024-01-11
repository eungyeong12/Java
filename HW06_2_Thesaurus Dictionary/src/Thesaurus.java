import java.util.ArrayList;

public class Thesaurus {
    private String keyword;
    private String type;
    private ArrayList<String> list_thesaurus = new ArrayList<>();

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
        String str = keyword + " [" + type + "] : {";
        for(int i=0; i<list_thesaurus.size(); i++) {
            str = str + list_thesaurus.get(i) + ", ";
        }
        str = str + "}";

        return str;
    }
}

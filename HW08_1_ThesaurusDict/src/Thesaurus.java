import java.util.*;

public class Thesaurus {
    private String keyword;
    private String type; // noun, verb, adj, adv, etc.
    private ArrayList<String> list_thesaurus = new ArrayList<>();

    public Thesaurus() {}
    public Thesaurus(String word, String type, String[] array_thesaurus) {
        this.keyword = word;
        this.type = type;
        for(String str : array_thesaurus) {
            this.list_thesaurus.add(str);
        }
    }
    public void setKeyWord(String word) {
        this.keyword = word;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void addThesaurus(String word) {
        this.list_thesaurus.add(word);
        Collections.sort(list_thesaurus);
    }
    public String toString() {
        String str = String.format("%5s [%3s] : {", this.keyword, this.type);
        for (String w : this.list_thesaurus) {
            str += w + ", ";
        }
        str += "}";
        return str;
    }
}

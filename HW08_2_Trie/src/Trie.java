import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Trie {
    private TrieNode _root;
    private String _name;
    public Trie(String nm) {
        this._root = new TrieNode('/', null);
        this._name = nm;
    }
    public String getName() {
        return this._name;
    }

    public void insert(String word) {
        TrieNode curTN = this._root;
        TreeMap<Character, TrieNode> children = curTN.getChildren();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
//TrieNode node;
            if(children.containsKey(c)) {
                curTN = children.get(c);
            } else {
                curTN = new TrieNode(c, curTN);
                children.put(c, curTN);
            }
            children = curTN.getChildren();
            if(i == word.length() - 1) {
                curTN.setLeaf(true);
                curTN.setKeyWord(word);
            }
        }
    }

    public boolean search(String word) {
        TrieNode curTN = _searchKeyword(word);
        if(curTN != null && curTN.isLeaf()) {
            return true;
        } else {
            return false;
        }
    }

    public TrieNode _searchKeyword(String word) {
        TrieNode curTN = this._root;
        TreeMap<Character, TrieNode> children
                = curTN.getChildren();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                curTN = children.get(c);
                children = curTN.getChildren();
            } else {
                curTN = null;
                break;
            }
        }
        return curTN;
    }
    public void _getKeywords(TrieNode curTN, ArrayList<String> keywords) {
        TrieNode tn;
        if (curTN.isLeaf()) {
            keywords.add(curTN.getKeyWord());
        }
        TreeMap<Character, TrieNode> children = curTN.getChildren();
        Set<Map.Entry<Character, TrieNode>> trieNodes = children.entrySet();
        for (Map.Entry<Character, TrieNode> entry : trieNodes) {
            tn = entry.getValue();
            if (tn.getChildren() != null) { _getKeywords(tn, keywords);
            }
        }
    }
    public ArrayList<String> getKeywords() {
        TrieNode curTN = this._root;
        ArrayList<String> keywords = new ArrayList<>(); _getKeywords(curTN, keywords);
        return keywords;
    }
    public ArrayList<String> getPredictiveWords(String keyword) {
        TrieNode curTN = _searchKeyword(keyword);
        ArrayList<String> keywords = new ArrayList<>(); _getKeywords(curTN, keywords);
        return keywords;
    }
}

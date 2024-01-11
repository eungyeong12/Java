import java.util.TreeMap;

public class TrieNode {
    private char ch;
    private String keyword;
    private TreeMap<Character, TrieNode>
            children = new TreeMap<>();
    private boolean isLeaf;
    public TrieNode() {}
    public TrieNode(char ch) { this.ch = ch; }

    public TrieNode(char c, Object o) {
    }

    public char getCh() { return this.ch; }
    public TreeMap<Character, TrieNode>
    getChildren() { return children; }
    public void setChildren(TreeMap<Character,
            TrieNode> children) { this.children = children; }
    public boolean isLeaf() { return isLeaf; }
    public void setLeaf(boolean isLeaf)
    { this.isLeaf = isLeaf; }
    public void setKeyWord(String keyword)
    { this.keyword = keyword; }
    public String getKeyWord() { return this.keyword; }
}

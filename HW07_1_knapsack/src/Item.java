public class Item {
    String name;
    int value;
    int weight;
    public Item(String nm, int val, int wt) {
        this.name = nm;
        this.value = val;
        this.weight = wt;
    }

    public String toString() {
        String str;
        str = String.format("(%s, %d, %d)", this.name, this.value, this.weight);
        return str;
    }
}

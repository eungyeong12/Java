public class CompleteBinaryTree<E> extends GenericArray<E> {
    String name;
    int CBT_capacity;
    int endIndex;

    public CompleteBinaryTree(int capa) {
        super(capa+1);
    }

    public CompleteBinaryTree(String name, int capacity) {
        super(capacity+1);
        this.name = name;
        this.CBT_capacity = capacity;
        this.endIndex = 0;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    public int addAtEnd(E entry) {
        if(this.endIndex >= this.CBT_capacity) {
            System.out.printf("%s is full now !!", this.name);
            return -1;
        }
        this.endIndex++;
        this.genArray[this.endIndex] = entry;
        return this.endIndex;
    }

    public E getCBTRoot() {
        E entry = (E)this.genArray[1];
        return entry;
    }

    public void removeCBTEnd() {
        this.endIndex--;
        this.size--;
    }

    protected int parentIndex(int index) {
        return index/2;
    }

    protected int leftChildIndex(int index) {
        return index*2;
    }

    protected int rightChildIndex(int index) {
        return index*2+1;
    }

    protected boolean hasLeftChild(int index) {
        return (index*2) <= endIndex;
    }

    protected boolean hasRightChild(int index) {
        return (index*2+1) <= endIndex;
    }

}

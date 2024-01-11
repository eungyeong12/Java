public class BinarySearchTreeNode<E> {
    private E _entry;
    private BinarySearchTreeNode<E> _parent;
    private BinarySearchTreeNode<E> _leftChild;
    private BinarySearchTreeNode<E> _rightChild;

    public BinarySearchTreeNode() {
        this._parent = null;
        this._leftChild = null;
        this._rightChild = null;
    }

    public BinarySearchTreeNode(E entry) {
        this._entry = entry;
        this._parent = null;
        this._leftChild = null;
        this._rightChild = null;
    }

    int compareKey(E otherEntry) {
        int cmpResult = 0;
        if (this._entry instanceof Integer) {
            cmpResult = (int) (this._entry) - (int) otherEntry;
        } else if (this._entry instanceof Double) {
            if ((double) (this._entry) > (double)otherEntry)
                cmpResult = 1;
            else if ((double) (this._entry) < (double)otherEntry)
                cmpResult = -1;
            else
                cmpResult = 0;
        } else if (this._entry instanceof String) {
            cmpResult = ((String)(this._entry)).compareTo((String)(otherEntry));
        } else {
            System.out.println("compareKey() is not defined for entry_type E !!");
        }
        return cmpResult;
    }

    public E getEntry() {
        return this._entry;
    }

    public void setEntry(E newEntry) {
        this._entry = newEntry;
    }

    public BinarySearchTreeNode<E> getParent() {
        return _parent;
    }

    public BinarySearchTreeNode<E> getLeftChild() {
        return _leftChild;
    }

    public BinarySearchTreeNode<E> getRightChild() {
        return _rightChild;
    }

    public void setParent(BinarySearchTreeNode<E> prBSTN) {
        this._parent = prBSTN;
    }

    public void setLeftChild(BinarySearchTreeNode<E> leftChildBSTN) {
        this._leftChild = leftChildBSTN;
    }

    public void setRightChild(BinarySearchTreeNode<E> rightChildBSTN) {
        this._rightChild = rightChildBSTN;
    }


}

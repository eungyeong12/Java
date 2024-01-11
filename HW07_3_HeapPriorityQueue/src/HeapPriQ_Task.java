public class HeapPriQ_Task extends CompleteBinaryTree<Task> {
    final int CBT_ROOT = 1;
    public HeapPriQ_Task(String name, int capacity) {
        super(name, capacity);
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size >= this.capacity;
    }

    public int size() {
        return this.size;
    }
    public void insert(Task ev) {
        int index, prIndex;
        if(isFull()) {
            System.out.printf("%s is full !!\n", this.name);
        }
        index = addAtEnd(ev);

        /* up-heap bubbling */
        while(index != CBT_ROOT)  {
            prIndex = parentIndex(index);
            Task curEv, prEv;
            curEv = (Task)this.genArray[index];
            prEv = (Task)this.genArray[prIndex];
            int curKey, prKey;
            curKey = (int)curEv.getPriority();
            prKey = (int)prEv.getPriority();
            if(curKey >= prKey) {
                break;
            } else {
                this.genArray[prIndex] = curEv;
                this.genArray[index] = prEv;
                index = prIndex;
            }
        }
        this.size++;
    }
    public Task removeHeapMin() {
        if(this.endIndex == 0) {
            return null;
        }
        Task minEv = (Task)getCBTRoot();
        if(this.size == 1) {
            removeCBTEnd();
        } else {
            Task curEv, chEv, rchEv;
            int curIndex, chIndex, rchIndex;
            int curPri, chPri, rchPri;
            Task temp_ev;
            this.genArray[CBT_ROOT] = this.genArray[this.endIndex];
            curIndex = CBT_ROOT;
            this.endIndex--;
            /* down-heap bubbling */
            while(hasLeftChild(curIndex)) {
                curEv = (Task)this.genArray[curIndex];
                curPri = curEv.getPriority();
                chIndex = leftChildIndex(curIndex);
                rchIndex = rightChildIndex(curIndex);
                chEv = (Task)this.genArray[chIndex];
                chPri = chEv.getPriority();
                if(hasRightChild(curIndex)) {
                    rchEv = (Task)this.genArray[rchIndex];
                    rchPri = rchEv.getPriority();
                    if(chPri > rchPri) {
                        // if right child has higher priority that left child
                        chEv = (Task)this.genArray[rchIndex];
                        chIndex = rchIndex;
                        chPri = rchPri;
                    }
                }
                if(curPri > chPri) {
                    // if child Ev's priority is higher than current Ev
                    /* swap curEv and chEv */
                    this.genArray[chIndex] = curEv;
                    this.genArray[curIndex] = chEv;
                }
                curIndex = chIndex;
            }
            this.size--;
        }
        return minEv;
    }
}

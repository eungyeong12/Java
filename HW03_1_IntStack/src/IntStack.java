public class IntStack {
    private int[] int_array;
    private int max_stack_size;
    private int stack_top = -1; // initial position

    public IntStack(int max_stack_size) {
        int_array = new int[max_stack_size];
    }

    public int push(int entry) {
        if(isFull())
            return 0;
        int_array[++stack_top] = entry;
        max_stack_size++;
        return int_array[stack_top];
    }

    public int pop() {
        if(isEmpty())
            return 0;
        max_stack_size--;
        return int_array[stack_top--];
    }

    public boolean isEmpty() {
        if(stack_top == -1)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if(max_stack_size == int_array.length)
            return true;
        else
            return false;
    }

    public void print() {
        for(int i=max_stack_size-1; i>-1; i--) {
            System.out.print(int_array[i] + " ");
        }
    }
}

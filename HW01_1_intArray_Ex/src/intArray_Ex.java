import java.util.Scanner;

/** Homework 1.1 */
public class intArray_Ex {
    public static void print_array(int[] array, int size) {
        if(size <= 10) {
            for(int i=0; i<size; i++) {
                System.out.printf("%3d ", array[i]);
            }
        } else {
            for(int i=0; i<10; i++) {
                System.out.printf("%3d ", array[i]);
            }
            System.out.println();
            for(int i=0; i<size-10; i++) {
                System.out.printf("%3d ", array[i]);
            }
        }

    }
    public static int[] get_int_array(Scanner cin, int size) {
        int[] array = new int[size];
        for(int i=0; i<size; i++) {
            array[i] = cin.nextInt();
        }
        return array;
    }
    public static void insertion_sort(int[] array, int size) {
        /* sort given array with insertion_sort algorithm */
        int temp, i, j;
        for(i=1; i<=(size-1); i++) {
            temp = array[i];
            j = i;
            for(;j>0 && array[j-1] >= temp; --j) {
                array[j] = array[j-1]; // shift right to make a room
            }
            array[j] = temp;
        }
    }
    public static void main(String args[]) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Please input number of integers to process:");
        int num_data = cin.nextInt();
        int[] int_array;
        System.out.print("Please input "+num_data + " integers in a line, separated with space:");
        int_array = get_int_array(cin, num_data);
        System.out.println("Input data: ");
        print_array(int_array, num_data);
        System.out.println();
        insertion_sort(int_array, num_data);
        System.out.println("Sorted input data:");
        print_array(int_array, num_data);
    }

}

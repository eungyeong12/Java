import java.util.Scanner;

public class Main {
    private static int[] genBigRandIntArray(int size, int offset) {
        int[] bigIntArray = new int[size];
        int j, temp;
        for(int i=0; i<size; i++)
            bigIntArray[i] = i + offset;
        for(int i=0; i<size; i++) {
            j = (int) (Math.random() * size);
            if (j == i)
                continue;
            temp = bigIntArray[i];
            bigIntArray[i] = bigIntArray[j];
            bigIntArray[j] = temp;
        }
        return bigIntArray;
    }

    private static void shuffleBigRnadIntArray(int[] bigRandIntArray) {
        int j, temp, size = bigRandIntArray.length;
        int[] bigIntArray = new int[size];
        for(int i=0; i<size; i++) {
            j = (int) (Math.random() * size);
            if (j == i)
                continue;
            temp = bigIntArray[i];
            bigIntArray[i] = bigIntArray[j];
            bigIntArray[j] = temp;
        }
    }
    private static void selection_sort(int[] bigRandIntArray) {
        int temp, min_dix, size =bigRandIntArray.length;
        for(int i=0; i<size-1; i++) {
            min_dix = i;
            for(int j=i+1; j<size; j++) {
                if(bigRandIntArray[min_dix] > bigRandIntArray[j])
                    min_dix = j;
            }
            if(min_dix != i) {
                temp = bigRandIntArray[i];
                bigRandIntArray[i] = bigRandIntArray[min_dix];
                bigRandIntArray[min_dix] = temp;
            }
        }
    }

    private static void insertion_sort(int[] bigRandIntArray) {
        int temp, i, j;
        for(i=1; i<=bigRandIntArray.length-1; i++) {
            temp = bigRandIntArray[i];
            j = i;
            for(;j>0 && bigRandIntArray[j-1] >= temp; --j) {
                bigRandIntArray[j] = bigRandIntArray[j-1]; // shift right to make a room
            }
            bigRandIntArray[j] = temp;
        }
    }

    public static int _partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue; // pivot value
        int newPI; // new pivot index
        int temp, i;

        pivotValue = array[pivotIndex];

        temp = array[pivotIndex];
        array[pivotIndex] = array[right];
        array[right] = temp; // Move pivot to end

        newPI = left;
        for(i=left; i<=(right-1); i++) {
            if(array[i] <= pivotValue) {
                temp = array[i];
                array[i] = array[newPI];
                array[newPI] = temp;
                newPI = newPI + 1;
            }
        }

        // swap array[storeIndex] and array[right]; Move pivot to its final place
        temp = array[newPI];
        array[newPI] = array[right];
        array[right] = temp;

        return newPI;
    }
    public static void _quickSort(int[] array, int left, int right) {
        int pI, newPI; // pivot index

        if(left >= right) {
            return;
        }
        pI = (left + right)/2;
        newPI = _partition(array, left, right, pI);

        if(left < (newPI - 1)) {
            _quickSort(array, left, newPI-1);
            // recursively sort elements on the left of pivotNewIndex
        }
        if((newPI + 1) < right) {
            _quickSort(array, newPI + 1, right);
            //recursively sort elements on the right of pivotNewIndex
        }
    }

    private static void quickSort(int[] bigRandIntArray) {
        int size = bigRandIntArray.length;
        _quickSort(bigRandIntArray,0, size-1);
    }


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int big_size;
        int test_sizes[] = {10, 20, 30, 40, 50, 70, 100, 200, 500, 1000};
        int offset = 0;
        int[] bigRandIntArray;
        long t1, t2, elapsed_time_ns;
        long tns_quick, tns_insert, tns_select;
        System.out.printf("Comparisons of Sorting Algorithms\n");
        System.out.printf("%10s %10s %10s %10s\n", "test_size", "quick_sort", "insert_sort", "select_sort");
        for(int test_size: test_sizes) {
            bigRandIntArray = genBigRandIntArray(test_size, offset);
            t1 = System.nanoTime();
            quickSort(bigRandIntArray);
            t2 = System.nanoTime();
            tns_quick = t2-t1;

            shuffleBigRnadIntArray(bigRandIntArray);
            t1 = System.nanoTime();
            insertion_sort(bigRandIntArray);
            t2 = System.nanoTime();
            tns_insert = t2-t1;

            shuffleBigRnadIntArray(bigRandIntArray);
            t1 = System.nanoTime();
            selection_sort(bigRandIntArray);
            t2 = System.nanoTime();
            tns_select = t2-t1;
            System.out.printf("%10d %10d %10d %10d\n", test_size, tns_quick, tns_insert, tns_select);
        }
    }
}
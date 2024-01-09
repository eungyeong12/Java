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

    public static void printBigArraySample(int[] bigArray, int per_line, int sample_lines) {
        // 배열의 원소들 중 첫부분과 끝부분에서 한 줄에 per_line 개씩의 원소를 smple_lines 줄씩 출력하는 함수
        int last_block_start;
        int size = bigArray.length, count = 0;

        for(int i=0; i<sample_lines; i++) {
            for(int j=0; j<per_line; j++) {
                if(count > size) {
                    System.out.printf("\n");
                    return;
                }
                System.out.printf("%8d ", bigArray[count]);
                count++;
            }
            System.out.printf("\n");
        }
        if(count < (size-per_line*sample_lines))
            count = size-per_line*sample_lines;

        System.out.printf("\n.....\n");

        for(int i=0; i<sample_lines; i++) {
            for(int j=0; j<per_line; j++) {
                if(count>size) {
                    System.out.printf("\n");
                    return;
                }
                System.out.printf("%8d", bigArray[count]);
                count++;
            }
            System.out.printf("\n");
        }
        System.out.printf("\n");
    }

    public static void shuffle_array(int[] bigRandIntArray) {
        int j, temp, size = bigRandIntArray.length;
        for(int i=0; i<size; i++) {
            j = (int) (Math.random() * size);
            if (j == i)
                continue;
            temp = bigRandIntArray[i];
            bigRandIntArray[i] = bigRandIntArray[j];
            bigRandIntArray[j] = temp;
        }
    }
    public static void selection_sort(int[] array) {
        int temp, min_dix, size =array.length;
        for(int i=0; i<size-1; i++) {
            min_dix = i;
            for(int j=i+1; j<size; j++) {
                if(array[min_dix] > array[j])
                    min_dix = j;
            }
            if(min_dix != i) {
                temp = array[i];
                array[i] = array[min_dix];
                array[min_dix] = temp;
            }
        }
    }

    public static void insertion_sort(int[] array) {
        int temp, i, j;
        for(i=1; i<=array.length-1; i++) {
            temp = array[i];
            j = i;
            for(;j>0 && array[j-1] >= temp; --j) {
                array[j] = array[j-1]; // shift right to make a room
            }
            array[j] = temp;
        }
    }

    public static void merge_sort(int[] array) {
        int[] temp = new int[array.length];
        merge_sort(array, temp, 0, array.length-1);
    }

    private static void merge_sort(int[] array, int[] temp, int start, int end) {
        if(start < end) {
            int mid = (start + end) / 2;
            merge_sort(array, temp, start, mid);
            merge_sort(array, temp, mid+1, end);
            merge(array, temp, start, mid, end);
        }
    }

    private static void merge(int[] array, int[] temp, int start, int mid, int end) {
        for(int i=start; i<=end; i++) {
            temp[i] = array[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while(part1 <= mid && part2 <= end) {
            if(temp[part1]  <= temp[part2]) {
                array[index] = temp[part1];
                part1++;
            } else {
                array[index] = temp[part2];
                part2++;
            }
            index++;
        }
        for(int i=0; i<=mid-part1; i++) {
            array[index + i] = temp[part1 + i];
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

    public static void quickSort(int[] array) {
        int size = array.length;
        _quickSort(array,0, size-1);
    }




    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int big_size;
        int offset = 0;
        int[] bigRandIntArray;
        long t1, t2, elapsed_time_ms;
        while (true) {
            System.out.print("input big_size (> 32767) to compare performances of (quick, selection) sorting algorithms (0 to terminate) : ");
            big_size = cin.nextInt();
            if (big_size == 0)
                break;
            bigRandIntArray = genBigRandIntArray(big_size, offset);
            System.out.printf("Before quick_sorting, size = %d, offset = %d\n", big_size, offset);
            printBigArraySample(bigRandIntArray, 10, 2);
            t1 = System.currentTimeMillis(); // t1 = System.nanoTime();
            quickSort(bigRandIntArray);
            t2 = System.currentTimeMillis(); // t2 = System.nanoTime();
            elapsed_time_ms = t2 - t1; // elapsed_time_ns = t2 - t1;
            System.out.printf("After quick_sorting, size = %d, offset = %d\n", big_size, offset);
            printBigArraySample(bigRandIntArray, 10, 2);
            System.out.printf("Quick_sort() for intArray(size=%d) took %d milliseconds\n", big_size, elapsed_time_ms);
//System.out.printf("Quick_sort() for intArray(size=%d) took %d nano-seconds\n", big_size, elapsed_time_ns);
            shuffle_array(bigRandIntArray);
            System.out.printf("Before merge_sorting, size = %d, offset = %d\n", big_size, offset);
            printBigArraySample(bigRandIntArray, 10, 2);
            t1 = System.currentTimeMillis();
            selection_sort(bigRandIntArray);
            t2 = System.currentTimeMillis();
            elapsed_time_ms = t2 - t1;
            System.out.printf("After merge_sorting, size = %d, offset = %d\n", big_size, offset);
            printBigArraySample(bigRandIntArray, 10, 2);
            System.out.printf("Merge_sort() for intArray(size=%d) took %d milliseconds\n", big_size, elapsed_time_ms);
            shuffle_array(bigRandIntArray);
            System.out.printf("Before insertion_sorting, size = %d, offset = %d\n", big_size, offset);
            printBigArraySample(bigRandIntArray, 10, 2);
            t1 = System.currentTimeMillis();
            insertion_sort(bigRandIntArray);
            t2 = System.currentTimeMillis();
            elapsed_time_ms = t2 - t1;
            System.out.printf("After insertion_sorting, size = %d, offset = %d\n", big_size, offset);
            printBigArraySample(bigRandIntArray, 10, 2);
            System.out.printf("Insertion_sort() for intArray(size=%d) took %d milliseconds\n", big_size, elapsed_time_ms);
            shuffle_array(bigRandIntArray);
            System.out.printf("Before selection_sorting, size = %d, offset = %d\n", big_size, offset);
            printBigArraySample(bigRandIntArray, 10, 2);
            t1 = System.currentTimeMillis();
            selection_sort(bigRandIntArray);
            t2 = System.currentTimeMillis();
            elapsed_time_ms = t2 - t1;
            System.out.printf("After selection_sorting, size = %d, offset = %d\n", big_size, offset);
            printBigArraySample(bigRandIntArray, 10, 2);
            System.out.printf("Selection_sort() for intArray(size=%d) took %d milliseconds\n", big_size, elapsed_time_ms);
        }
    }
}
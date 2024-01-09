import java.util.Scanner;

public class BigRandArray_QuickSort_Ex {
    public static int[] genBigRandIntArray(int size, int offset) {
        // (0~big_size) + offset 범위의 중복되지 않는 정수형 난수 배열을 생성하는 함수
        int[] bigIntArray = new int[size];
        int j, temp;
        for(int i=0; i<size; i++)
            bigIntArray[i] = i + offset;
        /* shuffle */
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
        _quickSort(array, 0, size-1);
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int big_size;
        int offset = 0;
        int[] bigRandIntArray;
        long t1, t2, elapsed_time_ms;
        while(true) {
            System.out.print("input big_size (> 32767) to generate non-deplicated ramdom big integer array (0 to terminate):");
            big_size = cin.nextInt();
            if(big_size == 0)
                break;
            bigRandIntArray = genBigRandIntArray(big_size, offset);
            System.out.printf("Before sorting, size = %d, offset = %d\n", big_size, offset);
            printBigArraySample(bigRandIntArray, 10, 2);
            t1 = System.currentTimeMillis();
            quickSort(bigRandIntArray);
            t2 = System.currentTimeMillis();
            elapsed_time_ms = t2-t1;
            System.out.printf("After sorting, size = %d, offset = %d\n", big_size, offset);
            printBigArraySample(bigRandIntArray, 10, 2);
            System.out.printf("quicksort() for intArray(size=%d) took %d milliseconds\n", big_size, elapsed_time_ms);
        }
    }
}

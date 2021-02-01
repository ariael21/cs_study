package Sorts;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class HeapSort {
    public static void main(String[] args) {

        int[] randomArray = IntStream.generate(() -> new Random().nextInt(100)).limit(35).toArray();
        int[] sorted = randomArray.clone();
        int[] heapSorted;
        Arrays.sort(sorted);

        for(int i = 0; i <= 20; i++) {
            randomArray = IntStream.generate(() -> new Random().nextInt(500)).limit(35).toArray();
            sorted = randomArray.clone();
            Arrays.sort(sorted);

            heapSorted = heapSort(randomArray);

            if(Arrays.equals(sorted, heapSorted)) System.out.print("\033[0;92m");
            else System.out.print("\033[0;91m");

            System.out.println("expected: " + Arrays.toString(sorted));
            System.out.println("output:   " + Arrays.toString(heapSorted));
        }
        System.out.print("\033[0m");
    }

    public static int[] heapSort(int[] array) {
        int[] sorted = new int[array.length];

        MaxHeap maxHeap = new MaxHeap(array);   // builds heap automatically
        int index = array.length-1;

        while(maxHeap.size() > 0) {
            sorted[index] = maxHeap.getMax();
            maxHeap.deleteMax();
            index--;
        }

        return sorted;
    }

}

class MaxHeap {
    final static int MAX_SIZE = 10000;

    private int n = 0;
    private int array[] = new int[MAX_SIZE];

    public MaxHeap(int[] values) {
        if(values.length <= array.length) {
            array = values;
            n = array.length;
            build();
        }
    }

    public void build() {
        for (int i = n / 2; i >= 0; i--) {
            shiftDown(i);
        }
    }

    public void insert(int value) {
        n += 1;
        array[n - 1] = value;
        shiftUp(n - 1);
    }

    public int getMax() {
        return array[0];
    }

    public void deleteMax() {
        array[0] = array[n - 1];
        n -= 1;
        shiftDown(0);
    }

    public void shiftUp(int i) {
        int parent = (i - 1) / 2;

        if (parent >= 0 && array[i] > array[parent]) {
            swap(parent, i);
            shiftUp(parent);
        }
    }

    public void shiftDown(int i) {
        int max = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;

        if (left < n && array[max] < array[left]) {
            max = left;
        }

        if (right < n && array[max] < array[right]) {
            max = right;
        }

        if (max != i) {
            swap(i, max);
            shiftDown(max);
        }
    }

    public void printHeap() {
        System.out.print("[");
        for(int i = 0; i < n; i++) {
            if(i == n-1) System.out.print(array[i]);
            else System.out.print(array[i] + ", ");
        }
        System.out.println("]");
    }

    public int size() {
        return n;
    }

    private void swap(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }
}

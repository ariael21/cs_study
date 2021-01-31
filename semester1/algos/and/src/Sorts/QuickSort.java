package Sorts;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = { 5, 6 , 3, 7, 2, 192, -23, 8};

        qSort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    public static void qSort(int[] array, int low, int high) {
        if (array.length <= 1)
            return;
        if (low < high) {
            int mid = partition(array, low, high);

            qSort(array, low, mid - 1); // watchout: pivot is max element => max != mid /!\
            qSort(array, mid + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {

        int p = array[high];
        int cLow = low;

        for(int i = low; i < high; i++) {
            if(array[i] < p) {
                // swap element to "smaller" side of array
                swap(i, cLow, array);
                cLow++; 
            }
        }

        swap(high, cLow, array);
        return cLow;
    }

    public static void swap(int i, int j, int[] array) {
        int prev = array[i];
        array[i] = array[j];
        array[j] = prev;
    }
}

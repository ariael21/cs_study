package Sorts;

public class InsertionSort {

    public static void main(String[] args) {
        // sample input
        int[] arr = {1, 4, 3, 7, 2, 12, 0, -3};

        Sort(arr);
        for(int num:arr) {
            System.out.print(num +", ");
        }
    }

    public static int[] Sort(int [] array) {
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {

                if(array[j] < array[j-1]) {
                    swap(j-1, j, array);
                }
                else {
                    break;
                }
            }
        }
        return array;
    }

    public static void swap(int i, int j, int[] arr) {
        int prev = arr[j];
        arr[j] = arr[i];
        arr[i] = prev;
    }
}

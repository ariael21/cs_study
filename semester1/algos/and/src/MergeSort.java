import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = { 1, 6 , 3, 7, 2, 192, -23, 5};

        MSort(array, 0, array.length-1);

        System.out.println(Arrays.toString(array));
    }

    public static void MSort(int[] array, int left, int right) {
        if(left != right) {
            int mid = (left + right) / 2;
            MSort(array, left, mid);
            MSort(array, mid + 1, right);
            Merge(array, left, mid + 1, right);
        }
    }

    public static void Merge(int[] array, int left, int mid, int right) {
        int[] temp = new int[array.length];
        int l = left;
        int m = mid;

        for(int i = left; i <= right; i++) {

            if(m <= right && l < mid) {
                if(array[l] > array[m]) {
                    temp[i] = array[m];
                    m++;
                }
                else {
                    temp[i] = array[l];
                    l++;
                }
            }
            else if(m <= right) {
                temp[i] = array[m];
                m++;
            }
            else if(l < mid) {
                temp[i] = array[l];
                l++;
            }
        }

        for(int i = left; i <= right; i++) {
            array[i] = temp[i];
        }
    }
}

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
        int prev;

        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {

                if(array[j] < array[j-1]) {
                    prev = array[j-1];
                    array[j-1] = array[j];
                    array[j] = prev;
                }
                else break;
            }
        }
        return array;
    }
}

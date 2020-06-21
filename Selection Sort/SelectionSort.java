import java.util.*;

public class SelectionSort {
    static Scanner ip = new Scanner(System.in);

    public static void main(String[] args) {
        int[] arr = { 21, 12, -5, 40, 10, 40 };

        for (int unsortedPartition = arr.length - 1; unsortedPartition > 0; unsortedPartition--) {
            int max = arr[0], maxIndex = 0;

            for (int i = 1; i <= unsortedPartition; i++) {
                if (arr[i] > max) {
                    maxIndex = i;
                }
            }

            swap(arr, maxIndex, unsortedPartition);
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int temp;
        temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

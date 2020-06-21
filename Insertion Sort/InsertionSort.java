import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        int[] arr = { 21, 12, -5, 40, 10, 40 };

        insertionSort(arr, 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void insertionSort(int[] arr, int unsortedIndex) {
        if (unsortedIndex == arr.length) {
            return;
        }

        int unsortedElement = arr[unsortedIndex];
        arr[insert(arr, unsortedIndex, unsortedElement)] = unsortedElement;

        insertionSort(arr, unsortedIndex + 1);
    }

    static int insert(int[] arr, int unsortedIndex, int unsortedElement) {
        if (unsortedIndex > 0 && unsortedElement < arr[unsortedIndex - 1]) {
            arr[unsortedIndex] = arr[unsortedIndex - 1];

            return insert(arr, unsortedIndex - 1, unsortedElement);
        }

        return unsortedIndex;
    }
}
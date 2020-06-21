import java.util.Arrays;

public class QuickSort {
    static int count = 0;
    public static void main(String[] args) {
        
        int[] arr = { 6497, -161, 5375, 2671, -812, 3009, 3480, 8388, 7218, 2666, 5060, 5759, 8065, 1649, 1712, -973, 6373, 122 };
        quickSort(arr, 0, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
            System.out.println("COUNT:" +count);
    }

    static void swap(int [] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int start, int end) {
        ++count;
        if (end - start < 2) {
            return;
        }

        int pivotIndex = (int)(Math.random()*(end - start)+start);
        swap(arr, start, pivotIndex);
        int pivot = arr[start], i = start, j = end;

        while (i < j) {
            while (arr[--j] >= pivot && i < j)
                ;

            if (i < j) {
                arr[i] = arr[j];
            }

            while (arr[++i] <= pivot && i < j)
                ;

            if (i < j) {
                arr[j] = arr[i];
            }
        }
        arr[j] = pivot;
        quickSort(arr, start, j);
        quickSort(arr, j + 1, end);
    }
}
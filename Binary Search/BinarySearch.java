import java.util.Arrays;

public class BinarySearch {
    public static int binarySearch(int[] arr, int element, int start, int end) {
        int mid = (start + end) / 2;

        if (end - start < 2 && arr[mid] != element) {
            return -1;
        }

        if (arr[mid] == element) {
            return mid;
        }

        if (element < arr[mid]) {
            return binarySearch(arr, element, start, mid);
        } else {
            return binarySearch(arr, element, mid, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 4, 5, 7 };
        Arrays.sort(arr);
        int position = binarySearch(arr, 8, 0, arr.length);

        if (position == -1) {
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at:" + (position + 1));
        }
    }
}
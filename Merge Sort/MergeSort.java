public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 21, 12, -5, 40, 10, 40, -35 };
        mergeSort(arr, 0, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void mergeSort(int[] arr, int start, int end) {
        if (end == start + 1) {
            return;
        }

        int mid = (start + end) / 2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid, end);
        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start];

        int i1 = start, i2 = mid, index = 0;

        while (i1 < mid && i2 < end) {
            temp[index++] = arr[i1] <= arr[i2] ? arr[i1++] : arr[i2++];
        }

        while (i1 < mid) {
            temp[index++] = arr[i1++];
        }

        while (i2 < end) {
            temp[index++] = arr[i2++];
        }

        System.arraycopy(temp, 0, arr, start, index);
    }
}
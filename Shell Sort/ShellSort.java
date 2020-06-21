public class ShellSort {
    public static void main(String[] args) {
        int[] arr = { 21, 12, -5, 40, 10, 40, -35 };

        for (int gap = arr.length / 2; gap >= 1; gap /= 2) {

            for (int i = gap; i < arr.length; i++) {
                int unsortedElement = arr[i];
                int j = i;

                while (j >= gap && unsortedElement < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = unsortedElement;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
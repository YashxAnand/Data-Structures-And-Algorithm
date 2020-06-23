import java.util.ArrayList;
import java.util.Arrays;

public class SubsetSum {

    boolean[][] memorizationTable;
    int[] values;
    int sum;

    public SubsetSum(int sum, int[] values) {
        memorizationTable = new boolean[values.length + 1][sum + 1];
        this.values = values;
        this.sum = sum;
        for (int i = 0; i <= values.length; i++) {
            memorizationTable[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            memorizationTable[0][i] = false;
        }
    }

    public void solve() {
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (memorizationTable[i - 1][j]) {
                    memorizationTable[i][j] = true;
                } else {
                    memorizationTable[i][j] = j - values[i - 1] >= 0 ? memorizationTable[i - 1][j - values[i - 1]]
                            : memorizationTable[i - 1][j];
                }
            }
        }

        System.out.println("Solution is :" + memorizationTable[values.length][sum]);
        ArrayList<Integer> items = new ArrayList<>();
        int j = sum;
        for (int i = values.length; i >= 1; i--) {
            if (memorizationTable[i][j] != memorizationTable[i - 1][j] && memorizationTable[i][j] != false) {
                items.add(values[i - 1]);
                j -= values[i - 1];
            }
        }

        items.forEach(element -> System.out.println("We take: " + element));
    }

    public static void main(String[] args) {
        int[] set = { 2, 3, 1, 5 };
        int sum = 13;
        SubsetSum ss = new SubsetSum(sum, set);
        ss.solve();
    }
}
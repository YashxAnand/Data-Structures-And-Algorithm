import java.util.ArrayList;

public class RodCutting {
    int lengthOfRod;
    int[] values;
    int[] lengths;
    int[][] memorizeTable;

    public RodCutting(int lengthOfRod, int[] values, int[] lengths) {
        this.lengthOfRod = lengthOfRod;
        this.values = values;
        this.lengths = lengths;

        memorizeTable = new int[values.length + 1][lengthOfRod + 1];
    }

    public void solve() {
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= lengthOfRod; j++) {
                memorizeTable[i][j] = Math.max(memorizeTable[i - 1][j],
                        j - lengths[i - 1] >= 0 ? values[i - 1] + memorizeTable[i][j - lengths[i - 1]] : 0);
            }
        }

        System.out.println("MAXIMUM PROFIT:" + memorizeTable[values.length][lengthOfRod]);

        ArrayList<Integer> items = new ArrayList<Integer>();
        int j = lengthOfRod;
        for (int i = values.length; i >= 1; i--) {
            while (memorizeTable[i][j] > memorizeTable[i - 1][j] && memorizeTable[i][j] != 0) {
                j -= lengths[i - 1];
                items.add(i);
            }
        }
        items.forEach(element -> System.out.print(element + " "));
    }

    public static void main(String[] args) {

        int[] values = { 2, 5, 7, 3 };
        int[] lengths = { 1, 2, 3, 4 };
        RodCutting rc = new RodCutting(5, values, lengths);
        rc.solve();
    }
}
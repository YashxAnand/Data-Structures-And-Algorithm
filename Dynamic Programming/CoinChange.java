public class CoinChange {
    int[] values;
    int M;
    int[][] memorizationTable;

    public CoinChange(int[] values, int M) {
        memorizationTable = new int[values.length + 1][M + 1];
        this.M = M;
        this.values = values;

        for (int i = 0; i <= values.length; i++) {
            memorizationTable[i][0] = 1;
        }
    }

    public void solve() {
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= M; j++) {
                if (j - values[i - 1] >= 0) {
                    memorizationTable[i][j] = memorizationTable[i - 1][j] + memorizationTable[i][j - values[i - 1]];
                } else {
                    memorizationTable[i][j] = memorizationTable[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= values.length; i++) {
            for (int j = 0; j <= M; j++) {
                System.out.print(memorizationTable[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] values = { 1, 2, 3, 4 };
        CoinChange cc = new CoinChange(values, 5);
        cc.solve();
    }
}
import java.util.ArrayList;

public class KnapSack {

    int[][] memorizeTable;
    int[] weights;
    int[] values;
    int weight;

    public KnapSack(int weight, int[] weights, int[] values) {
        memorizeTable = new int[values.length + 1][weight + 1];
        this.weight = weight;
        this.weights = weights;
        this.values = values;
    }

    public void solve() {
        for (int i = 1; i <= values.length; i++) {
            for (int j = 1; j <= weight; j++) {
                memorizeTable[i][j] = max(memorizeTable[i - 1][j],
                        +(j - weights[i - 1] < 0 ? 0 : values[i - 1] + memorizeTable[i - 1][j - weights[i - 1]]));
            }
        }

        int maxValue = memorizeTable[values.length][weight];
        ArrayList<Integer> listOfItems = new ArrayList<>();

        int j = weight;
        for (int i = values.length; i > 0; i--) {
            if (memorizeTable[i][j] > memorizeTable[i - 1][j] && memorizeTable[i][j] != 0) {
                j -= weights[i - 1];
                listOfItems.add(i);
            }
        }

        System.out.println("MAX VALUE: " + maxValue);
        System.out.print("ITEMS TO BE SELECTED:");
        listOfItems.forEach(element -> System.out.print(element + " "));
    }

    int max(int a, int b) {
        return (a > b ? a : b);
    }

    public static void main(String[] args) {
        int[] weights = { 0, 0, 0 };
        int[] values = { 0, 0, 0 };
        KnapSack ks = new KnapSack(6, weights, values);
        ks.solve();
    }
}
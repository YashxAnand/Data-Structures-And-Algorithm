public class TowerOfHanoi {

    public static void towerOfHanoi(int n, char From, char Middle, char To) {
        if (n == 1) {
            System.out.println("Plate 1 from " + From + " to " + To);
            return;
        }

        towerOfHanoi(n - 1, From, To, Middle);
        System.out.println("Plate " + n + " from " + From + " to " + To);
        towerOfHanoi(n - 1, Middle, From, To);
    }

    public static void main(String[] args) {
        towerOfHanoi(5, 'A', 'B', 'C');
    }
}
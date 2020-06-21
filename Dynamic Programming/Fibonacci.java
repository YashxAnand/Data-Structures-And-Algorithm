import java.util.Map;
import java.util.HashMap;

public class Fibonacci {

    Map<Long, Long> memorizeTable;

    public Fibonacci() {
        memorizeTable = new HashMap<>();
        memorizeTable.put(0l, 0l);
        memorizeTable.put(1l, 1l);
    }

    long solve(long n) {
        if (memorizeTable.containsKey(n)) {
            return memorizeTable.get(n);
        }

        memorizeTable.put(n - 1, solve(n - 1));
        memorizeTable.put(n - 2, solve(n - 2));
        long calculated = memorizeTable.get(n - 1) + memorizeTable.get(n - 2);
        memorizeTable.put(n, calculated);
        return calculated;
    }

    public static void main(String[] args) {
        Fibonacci fibo = new Fibonacci();
        fibo.solve(10);
    }
}
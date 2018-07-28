import java.util.*;

public class GCD {
    private static int gcd_naive(int a, int b) {
        int currentMin = Math.min(a, b);
        int currentMax = a + b - currentMin;

        while (currentMin > 0) {
            int temp = currentMin;
            currentMin = currentMax % currentMin;
            currentMax = temp;
        }

        return currentMax;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println(gcd_naive(a, b));
    }
}

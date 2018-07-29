import java.util.*;

public class FibonacciHuge {
    private static int getFibonacciHugeNaive(long n, int m) {
        int periodSize = getPeriodSize(m);
        int alternativeFibNum = (int) (n % periodSize);
        return getFibonacciLastDigitNaive(alternativeFibNum, m);
    }

    private static int getPeriodSize(int m) {
        int previous = 0;
        int current  = 1;

        int counter = 0;
        if (m == 0) {
            return counter;
        }

        counter = 1;
        if (m == 1) {
            return counter;
        }

        counter = 2;

        do {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
            counter++;
        } while (previous % m != 0 || current % m != 1);

        return counter - 2;
    }

    private static int getFibonacciLastDigitNaive(int n, int m) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current  = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % m;
        }

        return current;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int m = scanner.nextInt();
        System.out.println(getFibonacciHugeNaive(n, m));
    }
}
import java.util.*;

public class FibonacciSumSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresNaive(n);
        System.out.println(s);
    }

    private static long getFibonacciSumSquaresNaive(long n) {
        int lastDigitVertical = getFibonacciHuge(n);
        int lastDigitHorizontal = getFibonacciHuge(n + 1);

        return (lastDigitVertical * lastDigitHorizontal) % 10;
    }

    private static int getFibonacciHuge(long n) {
        int periodSize = getPeriodSize();
        int alternativeFibNum = (int) (n % periodSize);
        return getFibonacciLastDigitNaive(alternativeFibNum);
    }

    private static int getPeriodSize() {
        int previous = 0;
        int current = 1;
        int counter = 2;

        do {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
            counter++;
        } while (previous % 10 != 0 || current % 10 != 1);

        return counter - 2;
    }

    private static int getFibonacciLastDigitNaive(int n) {
        if (n <= 1)
            return n;

        int previous = 0;
        int current = 1;

        for (int i = 0; i < n - 1; ++i) {
            int tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current) % 10;
        }

        return current;
    }
}


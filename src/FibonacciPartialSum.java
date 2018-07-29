import java.util.*;

public class FibonacciPartialSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumNaive(from, to));
    }

    private static long getFibonacciPartialSumNaive(long from, long to) {
        int lastDigitFrom = getFibonacciHuge(from + 1);
        int lastDigitTo = getFibonacciHuge(to + 2);

        return (lastDigitTo + 10 - lastDigitFrom) % 10;
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


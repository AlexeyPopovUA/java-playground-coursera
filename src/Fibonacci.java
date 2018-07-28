import java.util.Scanner;

public class Fibonacci {
    private static long calc_fib(int n) {
        if (n <= 1)
            return n;

        int[] list = new int[n + 1];
        list[0] = 0;
        list[1] = 1;

        for (int i = 2; i <= n; i++) {
            list[i] = list[i - 2] + list[i - 1];
        }

        return list[n];
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(calc_fib(n));
    }
}

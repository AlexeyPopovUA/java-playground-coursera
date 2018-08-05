import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int[] coins = {10, 5, 1};
        int counter = 0;
        int sum = 0;

        for (int i = 0; i < coins.length && sum < m; i++) {
            while (m - sum >= coins[i]) {
                sum += coins[i];
                counter++;
            }
        }

        return counter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}


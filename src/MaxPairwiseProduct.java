import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.util.Collections.swap;


public class MaxPairwiseProduct {
    static BigInteger getMaxPairwiseProduct(ArrayList<BigInteger> numbers) {
        int index = 0;
        int n = numbers.size();

        for (int i = 1; i < n; i++) {
            if (numbers.get(i).compareTo(numbers.get(index)) > 0) {
                index = i;
            }
        }

        swap(numbers, n - 1, index);

        index = 0;

        for (int i = 1; i < n - 1; i++) {
            if (numbers.get(i).compareTo(numbers.get(index)) > 0) {
                index = i;
            }
        }

        swap(numbers, n - 2, index);

        return numbers.get(n - 1).multiply(numbers.get(n - 2));
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = new Integer(scanner.next());
        ArrayList<BigInteger> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(new BigInteger(scanner.next()));
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
    }
}
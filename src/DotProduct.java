import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        long result = 0;

        List<Integer> listA = new ArrayList<>(a.length);
        List<Integer> listB = new ArrayList<>(a.length);

        for (int i = 0; i < a.length; i++) {
            listA.add(i, a[i]);
            listB.add(i, b[i]);
        }

        Collections.sort(listA);
        Collections.sort(listB);

        for (int i = 0; i < listA.size(); i++) {
            result += ((long) listA.get(i)) * ((long) listB.get(i));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        System.out.println(maxDotProduct(a, b));
    }
}


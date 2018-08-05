import java.text.DecimalFormat;
import java.util.*;

class Item implements Comparable<Item> {
    private final int value;
    private final int weight;

    public Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public float getSingleItemValue() {
        return (float) getValue() / getWeight();
    }

    @Override
    public int compareTo(Item o) {
        return -Float.compare(this.getSingleItemValue(), o.getSingleItemValue());
    }
}

public class FractionalKnapsack {
    private static String getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;

        List<Item> items = new ArrayList<>(values.length);

        for (int i = 0; i < values.length; i++) {
            if (values[i] > 0 && weights[i] > 0) {
                items.add(i, new Item(values[i], weights[i]));
            }
        }
        Collections.sort(items);

        int length = items.size();
        for (int i = 0; i < length && capacity > 0; i++) {
            Item item = items.get(i);

            if (capacity >= item.getWeight()) {
                capacity -= item.getWeight();
                value += item.getValue();
            } else {
                float part = (float) capacity / item.getWeight();
                capacity -= item.getWeight() * part;
                value += item.getValue() * part;
            }
        }

        DecimalFormat df = new DecimalFormat();
        df.setGroupingUsed(false);
        df.setMaximumFractionDigits(4);
        df.setMinimumFractionDigits(4);

        return df.format(value);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 

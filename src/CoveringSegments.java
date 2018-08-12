import java.util.*;

public class CoveringSegments {

    private static List<Integer> optimalPoints(Segment[] segments) {

        List<Integer> points = new ArrayList<>();
        List<Segment> parts = new ArrayList<>(Arrays.asList(segments));
        Collections.sort(parts);

        List<List<Segment>> tempGroups = new ArrayList<>();

        int counter = 0;
        while (counter < segments.length) {
            int biggestEnd = parts.get(counter).end;
            List<Segment> tempSegments = new ArrayList<>();

            while (counter < segments.length && biggestEnd >= parts.get(counter).start) {
                tempSegments.add(tempSegments.size(), parts.get(counter));
                counter++;
            }

            if (tempSegments.size() > 0) {
                tempGroups.add(tempGroups.size(), tempSegments);
            }
        }

        for (List<Segment> group : tempGroups) {
            int minEnd = group.get(0).end;
            for (Segment aGroup : group) {
                if (aGroup.end < minEnd) {
                    minEnd = aGroup.end;
                }
            }

            points.add(points.size(), minEnd);
        }

        return points;
    }

    private static class Segment implements Comparable<Segment> {
        public int start;
        public int end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Segment o) {
            return Integer.compare(this.start, o.start);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
 

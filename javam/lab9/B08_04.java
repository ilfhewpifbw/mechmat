import java.util.PriorityQueue;

class Point implements Comparable<Point> {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceToOrigin() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public int compareTo(Point other) {
        return Double.compare(this.distanceToOrigin(), other.distanceToOrigin());
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

public class PointSorter {
    public static void main(String[] args) {
        PriorityQueue<Point> points = new PriorityQueue<>();
        points.add(new Point(3, 4));
        points.add(new Point(1, 1));
        points.add(new Point(0, 0));
        points.add(new Point(5, 12));

        while (!points.isEmpty()) {
            System.out.println(points.poll());
        }
    }
}

package first;
import java.util.*;
public class KthSmallestNumberInSortedMatrix {
	class Point {
        int val;
        int x;
        int y;
        public Point(int val, int x, int y) {
            this.val = val;
            this.x = x;
            this.y = y;
        }
    }
    class PointComparator implements Comparator<Point> {
        @Override
        public int compare (Point x, Point y) {
            return x.val - y.val;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return 0;
        }
        if (k > m * n) {
            return 0;
        }
        PriorityQueue<Point> heap = new PriorityQueue<Point>(k, new PointComparator());
        for (int i = 0; i < Math.min(k, n); i++) {
            heap.offer(new Point(matrix[0][i], 0, i));
        }
        Point curt = heap.peek();
        for (int i = 0; i < k; i++) {
            curt = heap.poll();
            if (curt.x + 1 < m) {
                heap.offer(new Point(matrix[curt.x + 1][curt.y], curt.x + 1, curt.y));
            }
        }
        return curt.val;
    }

}

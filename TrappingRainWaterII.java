package first;
import java.util.*;
public class TrappingRainWaterII {
	class Cell {
        int h;
        int x;
        int y;
        public Cell(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
    class CellComparator implements Comparator<Cell> {
        @Override
        public int compare(Cell c1, Cell c2) {
            return c1.h - c2.h;
        }
    }
    
    public int trapRainWater(int[][] heights) {
        int m = heights.length;
        if (m == 0) {
            return 0;
        }
        int n = heights[0].length;
        if (n == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Cell> heap = new PriorityQueue<Cell>(2 * (m + n), new CellComparator());
        for (int j = 0; j < n; j++) {
            heap.offer(new Cell(heights[0][j], 0, j));
            visited[0][j] = true;
            heap.offer(new Cell(heights[m - 1][j], m - 1, j));
            visited[m - 1][j] = true;
        }
        for (int i = 0; i < m; i++) {
            heap.offer(new Cell(heights[i][0], i, 0));
            visited[i][0] = true;
            heap.offer(new Cell(heights[i][n - 1], i, n - 1));
            visited[i][n - 1] = true;
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int res = 0;
        while (!heap.isEmpty()) {
            Cell curt = heap.poll();
            visited[curt.x][curt.y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = curt.x + dx[i];
                int nextY = curt.y + dy[i];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    res += Math.max(0, curt.h - heights[nextX][nextY]);
                    heap.offer(new Cell(Math.max(curt.h, heights[nextX][nextY]), nextX, nextY));
                    visited[nextX][nextY] = true;
                }
            }
        }
        return res;
    }

}

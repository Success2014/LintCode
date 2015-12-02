package first;

public class LongestIncreasingContinuousSubsequenceII {
	int[][] dp;
    boolean[][] visited;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        int m = A.length;
        if (m == 0) {
            return 0;
        }
        int n = A[0].length;
        if (n == 0) {
            return 0;
        }
        dp = new int[m][n];
        visited = new boolean[m][n];
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = search(A, i, j);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
    public int search(int[][] A, int x, int y) {
        if (visited[x][y]) {
            return dp[x][y];
        }
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int maxCurt = 1;
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if (nextX >= 0 && nextX < A.length && nextY >= 0 && nextY < A[0].length && A[x][y] > A[nextX][nextY]) {
                int res = search(A, nextX, nextY);
                maxCurt = Math.max(maxCurt, res + 1);
            }
        }
        visited[x][y] = true;
        return maxCurt;
    }

}

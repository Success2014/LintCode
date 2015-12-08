package first;

public class BackpackII {
	/**
	 * O(nm) time, O(nm) space.
	 * @param m
	 * @param A
	 * @param V
	 * @return
	 */
	public int backPackII(int m, int[] A, int V[]) {
        int n = A.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - A[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[n][m];
    }
	/**
	 * O(nm) time, O(m) space.
	 * @param m
	 * @param A
	 * @param V
	 * @return
	 */
	public int backPackII2(int m, int[] A, int V[]) {
        int n = A.length;
        int[] dp = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (j - A[i - 1] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return dp[m];
    }

}

package first;

public class Backpack {
	/**
	 * O(nm) time, O(nm) space.
	 * @param m
	 * @param A
	 * @return
	 */
	public int backPack(int m, int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        boolean[][] dp = new boolean[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
                if (j - A[i - 1] >= 0 && dp[i - 1][j - A[i - 1]]) {
                    dp[i][j] = true;
                }
            }
        }
        
        for (int i = m; i >= 1; i--) {
            if (dp[n][i]) {
                return i;
            }
        }
        return 0;
    }
	
	/**
	 * O(nm) time, O(m) space.
	 * @param m
	 * @param A
	 * @return
	 */
	public int backPack2(int m, int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        
        boolean[] dp = new boolean[m + 1];
        dp[0] = true;
        
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if (dp[j]) {
                    continue;
                }
                if (j - A[i - 1] >= 0 && dp[j - A[i - 1]]) {
                    dp[j] = true;
                }
            }
        }
        
        for (int i = m; i >= 1; i--) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }

}

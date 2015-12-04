package first;

public class CopyBooks {
	public int copyBooks(int[] pages, int k) {
        int n = pages.length;
        int[][] range = findTime(pages);
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][1] = range[1][i];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= k; j++) { // cannot assign 1 book to 2 people
                dp[i][j] = Integer.MAX_VALUE;
                for (int q = 1; q <= i - 1; q++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[q][j - 1], range[q + 1][i]));
                }
            }
        }
        if (k > n) {
        	return dp[n][n];
        }
        return dp[n][k];
    }
    public int[][] findTime(int[] pages) {
        int n = pages.length;
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + pages[i -1];
        }
        int[][] range = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                range[i][j] = preSum[j] - preSum[i - 1];
            }
        }
        return range;
    }
    public static void main(String[] args) {
    	CopyBooks cb = new CopyBooks();
    	int[] p1 = {3,2,4}; int k1 = 2;    	
    	int[] p2 = {1,2}; int k2 = 5;
    	System.out.println(cb.copyBooks(p2, k2));
    }

}

package first;

public class StoneGame {
	public int stoneGame(int[] A) {
        int n = A.length;
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[n + 1][n + 1];
        int[][] sum = findSum(A);
        for (int i = 0; i <= n; i++) {
            dp[i][i] = 0;
        }
        
        for (int len = 1; len <= n; len++) {
            for (int j = 1; j + len <= n; j++) {
                dp[j][j + len] = Integer.MAX_VALUE;
                for (int k = j; k < len + j; k++) {
                    dp[j][j + len] = Math.min(dp[j][j + len], dp[j][k] + dp[k + 1][j + len] + sum[j][j + len]);
                }
            }
        }
        return dp[1][n];
    }
    
    public int[][] findSum(int[] A) {
        int n = A.length;
        int[] preSum = new int[n + 1];
        preSum[0] = 0;
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + A[i - 1];
        }
        
        int[][] sum = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sum[i][j] = preSum[j] - preSum[i - 1];
            }
        }
        return sum;
    }
    public static void main(String[] args) {
    	StoneGame sg = new StoneGame();
    	int[] A1 = {1,1,1,1};
    	System.out.println(sg.stoneGame(A1));
    }

}

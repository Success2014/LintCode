package first;
import java.util.Arrays;
public class KSum {
	public int kSum(int A[], int k, int target) {
        int n = A.length;
        int[][][] dp = new int[n+1][k+1][target+1];//dp[i][j][t] select j numbers from the first i elments to add up to t
        Arrays.sort(A);
        for (int i = 0; i <=n ; i++) {
            dp[i][0][0] = 1;
        }
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k && j <= i; j++) {
                for (int t = 1; t <= target; t++) {
                    //dp[i][j][t] = 0;
                    if (t >= A[i-1]) {
                        dp[i][j][t] += dp[i-1][j-1][t- A[i-1]];
                    }
                    dp[i][j][t] += dp[i-1][j][t];
                }
            }
        }
        return dp[n][k][target];
    }

}

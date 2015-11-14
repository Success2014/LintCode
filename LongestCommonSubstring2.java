package first;

public class LongestCommonSubstring2 {
	public int longestCommonSubstring(String A, String B) {
        int m = A.length();
        int n = B.length();
        int[][] dp = new int[m][n];
        if (m == 0 || n == 0) {
            return 0;
        }
        
        int max = 0;
        for (int i = 0; i < m; i++) {
            if (A.charAt(i) == B.charAt(0)) {
                dp[i][0] = 1;
            }
            max = Math.max(max, dp[i][0]);
        }
        for (int j = 0; j < n; j++) {
            if (A.charAt(0) == B.charAt(j)) {
                dp[0][j] = 1;
            }
            max = Math.max(dp[0][j], max);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (A.charAt(i) == B.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}

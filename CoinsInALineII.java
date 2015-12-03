package first;

public class CoinsInALineII {
	public boolean firstWillWin(int[] values) {
        int n = values.length;
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n == 2) {
            return true;
        } else if (n == 3) {
            return values[0] + values[1] > values[2];
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = values[n - 1];
        dp[2] = values[n - 2] + values[n - 1];
        dp[3] = values[n - 3] + values[n - 2];
        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(values[n - i] + Math.min(dp[i - 2], dp[i -3]), values[n - i] + values[n - i+ 1] + Math.min(dp[i - 3], dp[i - 4]));
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += values[i];
        }
        return dp[n] > sum / 2;
    }

}

package first;

public class CoinsInALine {
	public boolean firstWillWin(int n) {
        if (n % 3 == 0) {
            return false;
        } else {
            return true;
        }
    }
	
	public boolean firstWillWin2(int n) {
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n == 2) {
            return true;
        } else if (n == 3) {
            return false;
        } else if (n == 4) {
            return true;
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = false;
        dp[1] = true;
        dp[2] = true;
        dp[3] = false;
        dp[4] = true;
        for (int i = 5; i <= n; i++) {
            dp[i] = (dp[i-2] && dp[i - 3]) || (dp[i -3] && dp[i - 4]);
        }
        return dp[n];
    }
}

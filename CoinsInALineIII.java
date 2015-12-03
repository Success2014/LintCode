package first;

public class CoinsInALineIII {
	public boolean firstWillWin(int[] values) {
        int n = values.length;
        if (n == 0) {
            return false;
        } else if (n == 1) {
            return true;
        } else if (n == 2) {
            return true;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = values[i];
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = Math.max(values[i], values[i + 1]);
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                dp[i][i + len] = Math.max(values[i] + Math.min(dp[i + 2][i + len], dp[i + 1][i + len - 1]), values[i + len] + Math.min(dp[i + 1][i + len - 1], dp[i][i + len - 2]));
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += values[i];
        }
        return dp[0][n - 1] >= sum / 2;
    }
	
	public static void main(String[] args) {
		CoinsInALineIII cia = new CoinsInALineIII();
		int[] v1 = {1,2,3,4,5,6,7,8,13,11,10,9};
		int[] v2 = {5,2,3,1};
		System.out.println(cia.firstWillWin(v1));
	}

}

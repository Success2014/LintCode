package first;

public class LongestCommonSubsequence {
	public int longestCommonSubsequenceM(String A, String B) {
        int m = A.length();
        int n = B.length();
        if (m == 0 || n == 0){
            return 0;
        }
        int[][] dp = new int[m+1][n+1];
        
        
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                if (A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + 1);
                }
                
            }
        }
        return dp[m][n];
    }
	
	public static void main(String[] args){
		String A1 = "bedaacbade";
		String B1 = "dccaeedbeb";
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		System.out.println(lcs.longestCommonSubsequenceM(A1, B1));
	}

}

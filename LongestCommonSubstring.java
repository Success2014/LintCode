package first;

public class LongestCommonSubstring {
	public int longestCommonSubstringM(String A, String B) {
        int m = A.length();
        int n = B.length();
        
        if (m == 0 || n == 0){
            return 0;
        }
        
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for (int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if (A.charAt(i-1) == B.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }
	
	public static void main(String[] args){
		String A1 = "hello";
		String B1 = "wella";
		LongestCommonSubstring lcs = new LongestCommonSubstring();
		System.out.println(lcs.longestCommonSubstringM(A1, B1));
		
	}

}

package first;
import java.util.*;
public class PostOfficeProblem {
	public int postOffice(int[] A, int k) {
        int n = A.length;
        int[][] dp = new int[n + 1][k + 1];
        if (k >= n) {
            return 0;
        }
        Arrays.sort(A);
        int[][] range = findDis(A);
        for (int i = 1; i <= n; i++) {
            dp[i][1] = range[1][i];
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int q = 1; q <= i - 1; q++) {
                    dp[i][j] = Math.min(dp[i][j], dp[q][j-1] + range[q+1][i]);
                }
            }
        }
        return dp[n][k];
    }
    public int[][] findDis(int[] A) {
        int n = A.length;
        int[][] range = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int mid = (i + j) / 2;
                range[i][j] = 0;
                for (int k = i; k <= j; k++) {
                    range[i][j] += Math.abs(A[k - 1] - A[mid - 1]);
                }
            }
        }
        return range;
    }
    public static void main(String[] args) {
    	PostOfficeProblem po = new PostOfficeProblem();
    	int[] A1 = {1,2,3,4,5}; int k1 = 2;
    	System.out.println(po.postOffice(A1, k1));
    }

}

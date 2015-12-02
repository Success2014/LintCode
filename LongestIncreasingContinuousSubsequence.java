package first;

public class LongestIncreasingContinuousSubsequence {
	public int longestIncreasingContinuousSubsequence(int[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;
        }
        int max = 1;
        int temp = 1;
        for (int i = 1; i < n; i++) {
            if (A[i] > A[i - 1]) {
                temp++;
            } else {
                temp = 1;
            }
            max = Math.max(max, temp);
        }
        temp = 1;
        for (int i = n - 1; i > 0; i--) {
            if (A[i - 1] > A[i]) {
                temp++;
            } else {
                temp = 1;
            }
            max = Math.max(max, temp);
        }
        return max;
    }

}

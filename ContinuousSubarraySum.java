package first;
import java.util.*;
public class ContinuousSubarraySum {
	public ArrayList<Integer> continuousSubarraySum(int[] A) {
		int n = A.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        if (n == 0) {
            return res;
        }
        int[] dp = new int[n + 1];
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + A[i - 1];
                end = i - 1;
                if (dp[i] > max) {
                    res.set(0, start);
                    res.set(1, end);
                    max = dp[i];
                }
            } else {
                dp[i] = A[i - 1];
                start = i - 1;
                end = i - 1;
                if (dp[i] > max) {
                	res.set(0, start);
                    res.set(1, end);
                    max = dp[i];
                }
            }
        }        
        return res;
    }
	public static void main(String[] args) {
		ContinuousSubarraySum css = new ContinuousSubarraySum();
		int[] A1 = {-3, 1, 3, -3, 4};
		int[] A2 = {1,1,1,-4,1,1,-5,1,1,1,1,1};
		int[] A3 = {-2,0,0,1,-1,-1};
		System.out.println(css.continuousSubarraySum(A3));
	}

}

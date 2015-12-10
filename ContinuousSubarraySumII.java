package first;
import java.util.*;
public class ContinuousSubarraySumII {
public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        
        ArrayList<Integer> res1 = find(A, 1);
        ArrayList<Integer> res2 = find(A, -1);
        
        if (res1.get(2) > res2.get(2)) {
            res1.remove(2);
            return res1;
        } else {
            res2.remove(2);
            return res2;
        }
        
    }
    public ArrayList<Integer> find(int[] A, int sign) {
        int n = A.length;
        int[] dp = new int[n + 1];
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        res.add(0);
        
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        if (sign == -1) {
            max = Integer.MAX_VALUE;
        }
        
        int sumAll = 0;
        for (int i = 1; i <= n; i++) {
            sumAll += A[i - 1];
            if (sign * dp[i - 1] >= 0) {
                dp[i] = dp[i - 1] + A[i - 1];
                end = i - 1;
                if (sign * dp[i] > sign * max) {
                    res.set(0, start);
                    res.set(1, end);
                    max = dp[i];
                }
            } else {
                dp[i] = A[i - 1];
                start = i - 1;
                end = i - 1;
                if (sign * dp[i] > sign * max) {
                	res.set(0, start);
                    res.set(1, end);
                    max = dp[i];
                }
            }
        }        
        if (sign == 1) {
            res.add(max);
            return res;
        }
        
        start = (res.get(1) + 1) % n;
        end = (res.get(0) - 1 + n) % n;
        res.set(0, start);
        res.set(1, end);
        if (sumAll == max) { // all the elements are negative
        	res.add(sumAll);
        } else {
        	res.add(sumAll - max);
        }
        return res;
    }
	public static void main(String[] args) {
		ContinuousSubarraySumII css = new ContinuousSubarraySumII();
		int[] A1 = {-5,10,5,-3,1,1,1,-2,3,-4};
		int[] A2 = {-101,-33,-44,-55,-67,-78,-101,-33,-44,-55,-67,-78,-100,-200,-1000,-22,-100,-200,-1000,-22};
		System.out.println(css.continuousSubarraySumII(A2));
	}

}

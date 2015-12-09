package first;
import java.util.*;
public class SubmatrixSum {
	public int[][] submatrixSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[2][2];
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                int[] sum = new int[n];
                for (int q = i; q <= j; q ++) {
                    for (int k = 0; k < n; k++) {
                        sum[k] += matrix[q][k];
                    }
                }
                
                int[] temp = find(sum);
                if (temp[0] != -1) {
                    res[0][0] = i;
                    res[0][1] = temp[0];
                    res[1][0] = j;
                    res[1][1] = temp[1];
                    return res;
                }
            }
        }
        return res;
    }
    public int[] find(int[] nums) {
        int n = nums.length;
        int[] res = {-1, -1};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int preSum = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            if (map.containsKey(preSum)) {
                res[0] = map.get(preSum) + 1;
                res[1] = i;
                break;
            } else {
                map.put(preSum, i);
            }
        }
        return res;
    }

}

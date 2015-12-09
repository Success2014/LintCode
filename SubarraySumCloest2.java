package first;
import java.util.*;
public class SubarraySumCloest2 {
	class Pair {
        int val;
        int index;
        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    class PairComparator implements Comparator<Pair> {
        @Override
        public int compare (Pair x, Pair y) {
            return x.val - y.val;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        int n = nums.length;
        Pair[] preSum = new Pair[n + 1];
        preSum[0] = new Pair(0, 0);
        for (int i = 1; i <= n; i++) {
            int temp = preSum[i - 1].val + nums[i - 1];
            preSum[i] = new Pair(temp, i);
        }
        Arrays.sort(preSum, new PairComparator());
        
        int min = Integer.MAX_VALUE;
        int[] res = new int[2];
        for (int i = 1; i <= n; i++) {
            if (Math.abs(preSum[i].val - preSum[i - 1].val) < min) {
                min = preSum[i].val - preSum[i - 1].val;
                res[0] = preSum[i - 1].index - 1;
                res[1] = preSum[i].index - 1;
                Arrays.sort(res);
                res[0] += 1;
            }
        }
        return res;
    }

}

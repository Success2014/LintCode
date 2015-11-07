package first;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class SubarraySumCloest {
	/**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        if (n == 1) {
            res.add(0);
            res.add(0);
            return res;
        }
        Pair[] prefixSum = new Pair[n + 1];
        prefixSum[0] = new Pair(0, 0);
        int sum = 0;
        for (int i = 1; i <= n; i ++) {
            sum += nums[i-1];
            prefixSum[i] = new Pair(sum, i);
        }
        Arrays.sort(prefixSum, new PairComparator());
        
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int diff = prefixSum[i].val - prefixSum[i-1].val;
            if (diff < min) {
                min = diff;
                res.clear();
                int[] temp = {prefixSum[i-1].index - 1, prefixSum[i].index - 1};
                Arrays.sort(temp);
                res.add(temp[0] + 1);
                res.add(temp[1]);
            }
        }
        return res;
    }
}


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
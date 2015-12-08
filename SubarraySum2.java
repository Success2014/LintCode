package first;
import java.util.*;
public class SubarraySum2 {
	public ArrayList<Integer> subarraySum(int[] nums) {
        int n = nums.length;
        int[] preSum = new int[n + 1];
        ArrayList<Integer> res = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 0);
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
            if (map.containsKey(preSum[i])) {
                res.add(map.get(preSum[i]));
                res.add(i - 1);
                break;
            } else {
                map.put(preSum[i], i);
            }
        }
        return res;
        
    }

}

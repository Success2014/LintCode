package first;
import java.util.ArrayList;
import java.util.HashMap;
public class SubarraySum {
	public ArrayList<Integer> subarraySum(int[] nums) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();//prefix sum, index
        int prefixSum = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++) {
            prefixSum += nums[i];
            
            if (map.containsKey(prefixSum)) {
                res.add(map.get(prefixSum) + 1);
                res.add(i);
                break;
            } else {
                map.put(prefixSum, i);
            }
        }
        return res;
    }

}

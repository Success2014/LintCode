package first;
import java.util.ArrayList;
public class MaximumSubarray {
	public int maxSubArray(ArrayList<Integer> nums) {
        if (nums.size() == 0) {
            return 0;
        }
        int local = nums.get(0);
        int global = nums.get(0);
        
        for (int i = 1; i < nums.size(); i++) {
            local = Math.max(local + nums.get(i), nums.get(i));
            global = Math.max(global, local);
        }
        return global;
    }
	public static void main (String[] args) {
		MaximumSubarray ms = new MaximumSubarray();
		ArrayList<Integer> nums =  new ArrayList<Integer>();
		nums.add(2);nums.add(-1);nums.add(4);
		System.out.println(ms.maxSubArray(nums));
	}

}

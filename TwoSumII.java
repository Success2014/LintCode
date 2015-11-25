package first;
import java.util.Arrays;
public class TwoSumII {
	public int twoSum2(int[] nums, int target) {
        int res = 0;
        int i = 0;
        int j = nums.length - 1;
        Arrays.sort(nums);
        while (i < j) {
            if (nums[i] + nums[j] > target) {
                res += j - i;
                j--;
            } else {
                i++;
            }
        }
        return res;
    }

}

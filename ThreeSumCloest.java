package first;
import java.util.Arrays;
public class ThreeSumCloest {
	public int threeSumClosest(int[] nums ,int target) {
        int n = nums.length;
        if (n < 3) {
            return Integer.MAX_VALUE;
        }
        Arrays.sort(nums);
        int cloest = Integer.MAX_VALUE / 2; // otherwise it will overflow for opeartion (closet-target)
        for (int i = 0; i < n; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > target) {
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    return sum;
                }
                if (Math.abs(cloest - target) > Math.abs(sum - target)) {
                    cloest = sum;
                }
            }
        }
        return cloest;
    }

}

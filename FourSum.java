package first;
import java.util.*;
public class FourSum {
	public ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target) {     
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int n = nums.length;
        if (n == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int left = j + 1;
                int right = n - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        ArrayList<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        res.add(list);
                        left++;
                        right--;
                        while (left < n && nums[left] == nums[left-1]) {
                            left++;
                        }
                        while (right >= 0 && nums[right] == nums[right+1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return res;
    }

}

package first;
import java.util.*;
public class RecoverRotatedSortedArray2 {
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        int idx = nums.size() - 1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                idx = i;
                break;
            }
        }
        reverse(nums, 0, idx);
        reverse(nums, idx + 1, nums.size() - 1);
        reverse(nums, 0, nums.size() - 1);
    }
    public void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            int temp = nums.get(start);
            nums.set(start, nums.get(end));
            nums.set(end, temp);
            start++;
            end--;
        }
    }

}

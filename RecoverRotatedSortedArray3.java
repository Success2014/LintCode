package first;
import java.util.*;
public class RecoverRotatedSortedArray3 {
	public void recoverRotatedSortedArray(ArrayList<Integer> nums) {
        int n = nums.size();
        if (n <= 1) {
            return;
        }
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) < nums.get(i - 1)) {
                index = i;
                break;
            }
        }
        reverse(nums, 0, index - 1);
        reverse(nums, index, n - 1);
        reverse(nums, 0, n - 1);
    }
    public void reverse(ArrayList<Integer> nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    public void swap(ArrayList<Integer> nums, int x, int y) {
        int temp = nums.get(x);
        nums.set(x, nums.get(y));
        nums.set(y, temp);
    }

}

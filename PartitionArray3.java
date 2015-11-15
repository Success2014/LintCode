package first;

public class PartitionArray3 {
	public int partitionArray(int[] nums, int k) {
	    int j = 0;
	    int n = nums.length;
	    for (int i = 0; i < n; i++) {
	        if (nums[i] < k) {
	            int temp = nums[i];
	            nums[i] = nums[j];
	            nums[j] = temp;
	            j++;
	        }
	    }
	    return j;
    }
}

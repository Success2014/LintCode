package first;

public class PartitionArray2 {
	public int partitionArray(int[] nums, int k) {
	    int n = nums.length;
	    int j = 0;
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

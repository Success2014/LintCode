package first;

public class PartitionArray4 {
	public int partitionArray(int[] nums, int k) {
	    int n = nums.length;
	    if (n == 0) {
	        return 0;
	    }
	    int i = 0;
	    int j = n - 1;
	    while (i <= j) {
	        while (i <= j && nums[i] < k) {
	            i++;
	        }
	        while (i <= j && nums[j] >= k) {
	            j--;
	        }
	        if (i <= j) {
	            swap(nums, i, j);
	            i++;
	            j--;
	        }
	    }
	    return i;
    }
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    
    public int partitionArray2(int[] nums, int k) {
	    int n = nums.length;
	    if (n == 0) {
	        return 0;
	    }
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

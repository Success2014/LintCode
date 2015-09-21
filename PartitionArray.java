package first;

public class PartitionArray {
	public int partitionArray(int[] nums, int k) {
        int j = 0;
	    for (int i = 0; i < nums.length; i++){
	        if (nums[i] >= k){
	            continue;
	        }
	        else{
	            int temp = nums[i];
	            nums[i] = nums[j];
	            nums[j] = temp;
	            j++;
	        }
	    }
	    return j;
    }
	
	public int partitionArray2(int[] nums, int k) {
        int i = 0, j = nums.length - 1;
        while (i <= j){
            while (i <= j && nums[i] < k){
                i++;
            }
            while (i <= j && nums[j] >= k){
                j--;
            }
            if (i <= j){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        return i;
        
        
    }
	
	public static void main(String[] args){
		PartitionArray pa = new PartitionArray();
		int[] nums1 = {9, 8, 1, 2, 6, 4, 3};
		System.out.println(pa.partitionArray(nums1, 5));
		int[] nums2 = {6,6,8,6,7,9,8,7,9,6,8,6,8,9,8,7,8,6,7,6,6,8,6,6};
		System.out.println(pa.partitionArray(nums2, 5));
		int[] nums3 = {4,2,1,3};
		System.out.println(pa.partitionArray(nums3, 5));
	}

}

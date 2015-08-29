package first;

public class BinarySearch {
	/**
     * @param nums: The integer array.
     * @param target: Target to find.
     * @return: The first position of target. Position starts from 0.
     */
    public int binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0, end = nums.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2 ;
            if (nums[mid] == target){
                end = mid;
            }
            else if (nums[mid] < target){
                start = mid;
            }
            else{
                end = mid;
            }
        }
        
        if (nums[start] == target) return start;
        if (nums[end] == target) return end;
        return -1;
    }
    
    public static void main(String[] args){
    	BinarySearch bs = new BinarySearch();
    	int[] nums1 = {1,2,2,3,4};
    	int target1 = 2;
    	System.out.println(bs.binarySearch(nums1, target1));
    }

}

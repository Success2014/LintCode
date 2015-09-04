package first;

public class RemoveDuplicatesFromSortedArrayII {
	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        if (nums.length <= 2){
            return nums.length;
        }
        int j = 1;
        for (int i = 2; i < nums.length; i++){
            if (nums[i] == nums[j] && nums[i] == nums[j-1]){
                continue;
            }
            else{
            	j++;
                nums[j] = nums[i];                
            }
        }
        return j + 1;
        
    }
	
	public static void main(String[] args){
		RemoveDuplicatesFromSortedArrayII rdf = new RemoveDuplicatesFromSortedArrayII();
		int[] nums1 = {1,1,1,2,2,3};//when the 3rd 1 changed to 2, what should you do?
		System.out.println(rdf.removeDuplicates(nums1));
	}

}

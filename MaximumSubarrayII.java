package first;
import java.util.*;
public class MaximumSubarrayII {
	public int maxTwoSubArrays(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] left = new int[nums.size()];  
  
        int localMax = 0;  
        int globalMax = Integer.MIN_VALUE;  
        for (int i = 0; i < nums.size(); i++) {  
            localMax = Math.max(nums.get(i), localMax + nums.get(i));  
            globalMax = Math.max(localMax, globalMax);  
            left[i] = globalMax;  
        }  
          
        localMax = 0;  
        globalMax = Integer.MIN_VALUE;  
        int result = Integer.MIN_VALUE;  
        for (int i = nums.size()-1; i >= 0; i--) {  
            if (i < nums.size()-1) {  
                result = Math.max(result, left[i] + globalMax);  
            }  
            localMax = Math.max(nums.get(i), localMax + nums.get(i));  
            globalMax = Math.max(localMax, globalMax);  
        }  
        return result;
    }

}

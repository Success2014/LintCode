package first;

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] num) {
        int start = 0, end = num.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (num[mid] > num[end]){//mid in left part, discard left part
                start = mid;
            }
            else{//mid in right part, discard right part
                end = mid;
            }
        }
        
        if (num[start] < num[end]){
            return num[start];
        }
        return num[end];
    }

}

package first;

public class SearchInRotatedSortedArray {
	/**
	 * idea:
	 * There are two ascending parts in the rotated array. 
	 * First figure out binary search middle is in which part.
	 * Then figure out if target is within this part.
	 * Discard useless part each time.
	 * @param A
	 * @param target
	 * @return
	 */
	public int search(int[] A, int target) {
        if (A == null || A.length == 0) return -1;
        int start = 0, end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] == target) return mid;
            else if (A[mid] > A[end]){ // in left ascending part
                if (target <= A[mid] && target >= A[start]){//target within
                    end = mid;
                }
                else{
                    start = mid;
                }
            }
            else{
                if (target <= A[end] && target >= A[mid]){//target within
                    start = mid;
                }
                else{
                    end = mid;
                }
            }
        }
        
        if (A[start] == target){
            return start;
        }
        else if (A[end] == target){
            return end;
        }
        else{
            return -1;
        }
    }

}

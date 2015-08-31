package first;

public class SearchInRotatedSortedArrayII {
	public boolean search1(int[] A, int target) {
        if (A == null || A.length == 0) return false;
        
        int start = 0, end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] == target) return true;
            if (A[mid] == A[end]){
                if (A[start] >= A[end]) start++;
                else end--;
            }
            else if (A[mid] < A[end]){//in right part
                if (target >= A[mid] && target <= A[end]) start = mid;
                else end = mid;
            }
            else{//in left part
                if (target >= A[start] && target <= A[mid]) end = mid;
                else start = mid;
            }
        }
        
        if (A[start] == target) return true;
        else if (A[end] == target) return true;
        else return false;
    }
	
	public boolean search(int[] A, int target) {
        if (A == null || A.length == 0) return false;
        
        for (int i = 0; i < A.length; i++){
            if (A[i] == target){
                return true;
            }
        }
        return false;
    }

}

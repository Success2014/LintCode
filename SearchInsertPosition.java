package first;

public class SearchInsertPosition {
	public int searchInsert(int[] A, int target) {
        if (A == null || A.length == 0) return 0;
        //find first position >= target
        int L = 0, R = A.length - 1;
        while (L + 1 < R){
            int M = L + (R - L) / 2;
            if (A[M] == target){
                return M;
            }
            else if (A[M] < target){
                L = M;
            }
            else{
                R = M;
            }
        }
        
        if (A[L] >= target){
            return L;
        }
        else if (A[R] >= target){
            return R;
        }
        else{
            return R + 1;
        }
    }

}

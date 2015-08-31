package first;

public class MedianOfTwoSortedArrays {
	public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        
        if ((m + n) % 2 == 1) return getKth(A, 0, B, 0, (m + n) / 2 + 1);
        else return 0.5*(getKth(A, 0, B, 0, (m + n) / 2) + getKth(A, 0, B, 0, (m + n) / 2 + 1));
        
    }
    public int getKth(int[] A, int A_start, int[] B, int B_start, int k){
        if (A_start >= A.length) return B[B_start + k - 1];
        if (B_start >= B.length) return A[A_start + k - 1];
        
        if (k == 1){
            return Math.min(A[A_start], B[B_start]);
        }
        
        //int A_key = (A_start + k / 2 - 1 < A.length)? A[A_start + k / 2 - 1]: A[A.length - 1];
        //int B_key = (B_start + k / 2 - 1 < B.length)? B[B_start + k / 2 - 1]: B[B.length - 1];
        int A_key = (A_start + k / 2 - 1 < A.length)? A[A_start + k / 2 - 1]: Integer.MAX_VALUE;
        int B_key = (B_start + k / 2 - 1 < B.length)? B[B_start + k / 2 - 1]: Integer.MAX_VALUE;
        //k/2 elements from the longer array cannot be the k-th element
        
        if (A_key < B_key){
            return getKth(A, A_start + k / 2, B, B_start, k - k / 2);
        }
        else{
            return getKth(A, A_start, B, B_start + k / 2, k - k / 2);
        }
        
    }
    
    public static void main(String[] args){
    	MedianOfTwoSortedArrays mts = new MedianOfTwoSortedArrays();
    	int[] A1 = {1,2,3,4,5,6};
    	int[] B1 = {1};
    	System.out.println(mts.findMedianSortedArrays(A1, B1));
    }

}

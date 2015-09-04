package first;

public class MergeSortedArray {
	public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0){
            if (B[j] > A[i]){
                A[k] = B[j];
                j--;
            }
            else{
                A[k] = A[i];
                i--;
            }
            k--;
        }
        while (j >= 0){
            A[k] = B[j];
            j--;
            k--;
        }
    }

}

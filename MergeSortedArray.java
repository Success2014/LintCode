package first;

public class MergeSortedArray {
	/**
	 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
	 * Example
		A = [1, 2, 3, empty, empty], B = [4, 5]
	
		After merge, A will be filled as [1, 2, 3, 4, 5]
		Note
		You may assume that A has enough space (size that is greater or equal to m + n) 
		to hold additional elements from B. The number of elements initialized in A and B 
		are m and n respectively.
	 * @param A
	 * @param m
	 * @param B
	 * @param n
	 */
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

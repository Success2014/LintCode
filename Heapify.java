package first;

public class Heapify {
	public void heapify(int[] A) {
        int n = A.length;
        for (int i = n / 2; i >= 0; i--) {
            helper(A, i, n);
        }
    }
    public void helper(int[] A, int i, int n) {
        int l = i * 2 + 1;
        int r = i * 2 + 2;
        int smallest = i;
        if (l < n && A[l] < A[i]) {
            smallest = l;
        }
        if (r < n && A[r] < A[smallest]) {
            smallest = r;
        }
        if (smallest != i) {
            int temp = A[i];
            A[i] = A[smallest];
            A[smallest] = temp;
            helper(A, smallest, n);
        }
        
    }

}

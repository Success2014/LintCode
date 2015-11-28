package first;

public class Heapify2 {
	public void heapify(int[] A) {
        int n = A.length;
        for (int i = n / 2; i >= 0; i--) {
            helper(A, i, n);
        }
    }
    public void helper(int[] A, int i, int n) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int min = i;
        if (l < n && A[l] < A[i]) {
            min = l;
        }
        if (r < n && A[r] < A[min]) {
            min = r;
        }
        if (min != i) {
            int temp = A[i];
            A[i] = A[min];
            A[min] = temp;
            helper(A, min, n);
        }
    }
    
    public static void main(String[] args) {
    	Heapify2 hp = new Heapify2();
    	int[] A = {45, 39, 32, 11};
    	hp.heapify(A);
    }

}

package first;

public class InterleavingPositiveAndNegativeNumbers {
	public void rerange(int[] A) {
        int posNum = 0;
        int negNum = 0;
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                negNum++;
            } else {
                posNum++;
            }
        }
        
        int posIndex = 0;
        int negIndex = 1;
        if (negNum > posNum) {
            posIndex = 1;
            negIndex = 0;
        }
        
        while (posIndex < n && negIndex < n) {
            while (posIndex < n && A[posIndex] > 0) {
                posIndex += 2;
            }
            while (negIndex < n && A[negIndex] < 0) {
                negIndex += 2;
            }
            if (posIndex < n && negIndex < n) {
                swap(A, posIndex, negIndex);
                posIndex += 2;
                negIndex += 2;
            }
        }
        
   }
   
   public void swap(int[] A, int x, int y) {
       int temp = A[x];
       A[x] = A[y];
       A[y] = temp;
   }

}

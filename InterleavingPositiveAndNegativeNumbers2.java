package first;

public class InterleavingPositiveAndNegativeNumbers2 {
	public void rerange(int[] A) {
        int n = A.length;
        int posNum = 0;
        int negNum = 0;
        for (int i = 0; i < n; i ++) {
            if (A[i] > 0) {
                posNum++;
            } else {
                negNum++;
            }
        }
        
        int posIdx = 0;
        int negIdx = 1;
        if (posNum < negNum) {
            posIdx = 1;
            negIdx = 0;
        } 
        
        while (posIdx < n && negIdx < n) {
            while (posIdx < n && A[posIdx] > 0) {
                posIdx += 2;
            }
            while (negIdx < n && A[negIdx] < 0) {
                negIdx += 2;
            }
            if (posIdx < n && negIdx < n) {
                swap(A, posIdx, negIdx);
            }
        }
   }
   
   public void swap (int[] A, int x, int y) {
       int temp = A[x];
       A[x] = A[y];
       A[y] = temp;
   }

}

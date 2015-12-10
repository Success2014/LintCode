package first;
import java.util.*;
public class FindPeakElementII {
	public List<Integer> findPeakII(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int u = 1; // up
        int d = m - 2; // down
        int l = 1; // left
        int r = n - 2; // right
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (u <= d && l <= r) {
            int midRow = u + (d - u) / 2;
            int rowMax = findMax(A, midRow, true, u, d, l ,r);
            if (A[midRow][rowMax] < A[midRow - 1][rowMax]) {
                d = midRow - 1;
            } else if (A[midRow][rowMax] < A[midRow + 1][rowMax]) {
                u = midRow + 1;
            } else {
                res.add(midRow);
                res.add(rowMax);
                break;
            }
            
            int midCol = l + (r - l) / 2;
            int colMax = findMax(A, midCol, false, u, d, l, r);
            if (A[colMax][midCol] < A[colMax][midCol - 1]) {
                r = midCol - 1;
            } else if (A[colMax][midCol] < A[colMax][midCol + 1]) {
                l = midCol + 1;
            } else {
                res.add(colMax);
                res.add(midCol);
                break;
            }
        }
        return res;
    }
     
    public int findMax (int[][] A, int index, boolean isRow, int u, int d, int l, int r) {
        int m = A.length;
        int n = A[0].length;
        
        int maxIndex = 0;
        if (isRow) {
            maxIndex = l;
            for (int i = l; i <= r; i++) {
                if (A[index][i] > A[index][maxIndex]) {
                    maxIndex = i;
                }
            }
        } else {
            maxIndex = u;
            for (int i = u; i <= d; i++) {
                if (A[i][index] > A[maxIndex][index]) {
                    maxIndex = i;
                }
            }
        }
        return maxIndex;
    }

}

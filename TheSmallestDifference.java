package first;
import java.util.*;
public class TheSmallestDifference {
	public int smallestDifference(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int m = A.length;
        int i = 0;
        int n = B.length;
        int j = 0;
        int diff = Integer.MAX_VALUE;
        while (i < m && j < n) {
            if (A[i] == B[j]) {
                return 0;
            } else if (A[i] < B[j]) {
                diff = Math.min(diff, B[j] - A[i]);
                i++;
            } else {
                diff = Math.min(diff, A[i] - B[j]);
                j++;
            }
        }
        return diff;
    }

}

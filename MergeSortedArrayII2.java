package first;
import java.util.*;
public class MergeSortedArrayII2 {
	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        int m = A.size();
        int n = B.size();
        
        int i = 0;
        int j = 0;
        
        while (i < m && j < n) {
            if (A.get(i) < B.get(j)) {
                res.add(A.get(i));
                i++;
            } else {
                res.add(B.get(j));
                j++;
            }
        }
        
        while (i < m) {
            res.add(A.get(i));
            i++;
        }
        while (j < n) {
            res.add(B.get(j));
            j++;
        }
        return res;
    }

}

package first;

import java.util.ArrayList;

public class MergeSortedArrayII {
	public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (A == null && B == null){
            return res;
        }
        int m = A.size();
        int n = B.size();
        int r = m + n;
        
        A.add(Integer.MAX_VALUE);
        B.add(Integer.MAX_VALUE);
        
        int i = 0, j = 0;
        for (int k = 0; k < r; k++){
            if (A.get(i) < B.get(j)){
                res.add(A.get(i));
                i++;
            }
            else{
                res.add(B.get(j));
                j++;
            }
        }
        
        return res;
    }

}

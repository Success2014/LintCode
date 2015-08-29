package first;

import java.util.ArrayList;

public class SearchForARange {
	public ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        ArrayList<Integer> bound = new ArrayList<Integer>();
        if (A == null || A.size() == 0){
            bound.add(-1);bound.add(-1);
            return bound;
        }
        // find left bound
        int L = 0, R = A.size() - 1;
        while (L + 1 < R){
            int M = L + (R - L) / 2;
            if (A.get(M) == target){
                R = M;
            }
            else if (A.get(M) < target){
                L = M;
            }
            else{
                R = M;
            }
        }
        
        if (A.get(L) == target){
            bound.add(L);
        }
        else if (A.get(R) == target){
            bound.add(R);
        }
        else{
            bound.add(-1);bound.add(-1);
            return bound;
        }
        
        // find right bound
        L = 0; R = A.size() - 1;
        while (L + 1 < R){
            int M = L + (R - L) / 2;
            if (A.get(M) == target){
                L = M;
            }
            else if (A.get(M) < target){
                L = M;
            }
            else{
                R = M;
            }
        }
        
        if (A.get(R) == target){
            bound.add(R);
        }
        else if (A.get(L) == target){
            bound.add(L);
        }
        else{
            bound.add(-1);bound.add(-1);
            return bound;
        }
        
        return bound;
    }
	
	public static void main(String[] args){
		SearchForARange sfr = new SearchForARange();
		ArrayList<Integer> A = new ArrayList<Integer>();
		A.add(5);A.add(5);A.add(5);A.add(5);A.add(5);A.add(5);A.add(5);A.add(5);
		System.out.println(sfr.searchRange(A, 5));
	}

}

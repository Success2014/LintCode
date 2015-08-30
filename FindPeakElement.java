package first;

public class FindPeakElement {
	public int findPeak(int[] A) {
        int start = 0, end = A.length - 1;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid - 1]){//going down, must have peak on left
                end = mid;
            }
            else if (A[mid] < A[mid + 1]){//going up, must have peak on right
                start = mid;
            }
            else{//peak found
                end = mid;//or start = mid, both are right as long as answer is kept. 
            }
        }
        
        if (A[end] > A[start]){//could be start or end 
            return end;
        }
        else{
            return start;
        }
    }
	
	public static void main(String[] args){
		FindPeakElement fpe = new FindPeakElement();
		int[] A1 = {100,102,104,7,9,11,4,3};
		System.out.println(fpe.findPeak(A1));
	}

}

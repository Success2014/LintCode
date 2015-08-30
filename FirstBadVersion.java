package first;

public class FirstBadVersion {
	public int findFirstBadVersion(int n) {
        // OXXXX OOXXX OOOXX
        // find first position of X
        int start = 1, end = n;
        while (start + 1 < end){
            int mid = start + (end - start) / 2;
            if (VersionControl.isBadVersion(mid)){
                end = mid;
            }
            else{
                start = mid;
            }
        }
        
        if (VersionControl.isBadVersion(start)){
            return start;
        }
        else{
            return end;
        }
    }

}


class VersionControl {
	public static boolean isBadVersion(int k){
		return true;
	};
}
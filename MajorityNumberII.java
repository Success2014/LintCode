package first;
import java.util.ArrayList;
public class MajorityNumberII {
	public int majorityNumber(ArrayList<Integer> nums) {
        Integer cand1 = null;
        int c1 = 0;
        Integer cand2 = null;
        int c2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (cand1 != null && nums.get(i) == cand1.intValue()) {
                c1++;
            } else if (cand2 != null && nums.get(i) == cand2.intValue()) {
                c2++;
            } else if (c1 == 0) {
                cand1 = nums.get(i);
                c1 = 1;
            } else if (c2 == 0) {
                cand2 = nums.get(i);
                c2 = 1;
            } else {
                c1--;
                c2--;
            }
        }
        
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (cand1 != null && nums.get(i) == cand1.intValue()) {
                c1++;
            }
            else if (cand2 != null && nums.get(i) == cand2.intValue()) {
                c2++;
            }
        }
        
        
        if (c1 > c2 ) {
            return cand1.intValue();
        }
        else {
            return cand2.intValue();
        }
        
    }

}

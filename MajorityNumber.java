package first;
import java.util.ArrayList;
public class MajorityNumber {
	public int majorityNumber(ArrayList<Integer> nums) {
        int candidate = nums.get(0);
        int count = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) == candidate) {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                candidate = nums.get(i);
                count = 1;
            }
        }
        return candidate;
    }

}

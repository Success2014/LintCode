package first;
import java.util.*;
public class SlidingWindowMaximum {
	public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (n == 0 || k == 0) {
            return res;
        }
        
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i ++) {
            if (deque.isEmpty()) {
                deque.offer(i);
            } else {
                // remove smaller numbers in k range as they are useless
                while (!deque.isEmpty() && nums[i] > nums[deque.peekLast()]) {
                    deque.pollLast();
                }
                deque.offerLast(i);
                // remove numbers out of range k
                while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                    deque.pollFirst();
                }
            }
            if (i >= k - 1) {
                res.add(nums[deque.peekFirst()]);
            }
        }
        return res;
    }
}

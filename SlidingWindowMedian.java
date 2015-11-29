package first;
import java.util.*;
public class SlidingWindowMedian {
	class newComparator implements Comparator<Integer> {
        @Override
        public int compare (Integer x, Integer y) {
            return y - x;
        }
    }
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        if (n < k) {
            return res;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new newComparator());
        for (int i = 0; i < n; i++) {
            if (maxHeap.size() == 0) {
                maxHeap.offer(nums[i]);
            } else if (nums[i] > maxHeap.peek()) {
                minHeap.offer(nums[i]);
            } else {
                maxHeap.offer(nums[i]);
            }
            
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } 
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
            
            if ((i + 1) >= k) {
                res.add(maxHeap.peek());
                int toRemove = nums[i + 1 - k];
                if (toRemove <= maxHeap.peek()) {
                    maxHeap.remove(toRemove);
                } else {
                    minHeap.remove(toRemove);
                }
            }
            
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.offer(maxHeap.poll());
            } 
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }
        return res;
    }

}

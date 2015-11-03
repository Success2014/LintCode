package first;

import java.util.Comparator;
import java.util.PriorityQueue;

public class DataStreamMedian {
	public int[] medianII(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new newComparator());
        int n = nums.length;
        int[] res = new int[n];
        if (n == 0) {
            return res;
        }
        res[0] = nums[0];
        maxHeap.offer(nums[0]);
        
        for (int i = 1; i < n; i++) {
            int prevMedian = maxHeap.peek();
            if (nums[i] > prevMedian) {
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
            res[i] = maxHeap.peek();
        }
        return res;
    }
    class newComparator implements Comparator<Integer> {
        @Override
        public int compare (Integer x, Integer y) {
            return y - x;
        }
    }

}

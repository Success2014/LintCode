package first;
import java.util.*;
public class DataStreamMedian2 {
	class newComparator implements Comparator<Integer> {
        @Override
        public int compare (Integer x, Integer y) {
            return y - x;
        }
    }
    public int[] medianII(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if (n == 0) {
            return res;
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(11, new newComparator());
        maxHeap.offer(nums[0]);
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            int temp = maxHeap.peek();
            if (nums[i] > temp) {
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

}

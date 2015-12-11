package first;

public class SearchInABigSortedArray {
	class ArrayReader {
		public int get(int index) {
			return 1;
		}
	}
	public int searchBigSortedArray(ArrayReader reader, int target) {
        // Algorithm:
        // 1. get the index that ArrayReader.get(index) >= target or == -1 in
        //    O(logk)
        // 2. Binary search the target between 0 and index
        
        int index = 1; // initialize the index;
        
        while (reader.get(index) != -1 && reader.get(index) < target) {
            // multiply index by 2, so that we can get it in O(logk)
            index = index * 2;
        }
        
        int start = 0, end = index;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (reader.get(mid) != -1 && reader.get(mid) < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (reader.get(start) == target) {
            return start;
        } else if (reader.get(end) == target) {
            return end;
        } else {
            return -1;
        }
        
    }

}

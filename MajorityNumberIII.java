package first;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class MajorityNumberIII {
	public int majorityNumber(ArrayList<Integer> nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.size(); i++) {
            int key = nums.get(i);
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            
            if (map.size() == k) {
                removeKeys(map);
            }
        }
        
        for (int key: map.keySet()) {
            map.put(key, 0);
        }
        for (int num: nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
        }
        
        int maxCount = 0;
        int maxKey = Integer.MIN_VALUE;
        for (int key: map.keySet()) {
            if (map.get(key) > maxCount) {
                maxCount = map.get(key);
                maxKey = key;
            }
        }
        return maxKey;
    }
    public void removeKeys (HashMap<Integer, Integer> map) {
        List<Integer> removeList = new ArrayList<Integer>();
        for (int key: map.keySet()) {
            map.put(key, map.get(key) - 1);
            if (map.get(key) == 0) {
                removeList.add(key);
            }
        }
        
        for (int key: removeList) {
            map.remove(key);
        }
    }

}

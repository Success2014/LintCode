package first;
import java.util.*;
public class LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int n = s.length();
        int max = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < n; i++) {
            while (j < n) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    if (map.size() == k) {
                        break;
                    }
                    map.put(c, 1);
                }
                j++;
            }
            
            max = Math.max(max, j - i);
            
            char toRemove = s.charAt(i);
            if (map.get(toRemove) > 1) {
                map.put(toRemove, map.get(toRemove) - 1);
            } else {
                map.remove(toRemove);
            }
        }
        return max;
    }

}

package first;
import java.util.*;
public class ThreeSum {
	public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        int n = numbers.length;
        if (n == 0) {
            return res;
        }
        Arrays.sort(numbers);
        for (int i = 0; i < n; i++) {
            if (i != 0 && numbers[i] == numbers[i-1]) {
                continue;  //to skip duplicate numbers; e.g [0,0,0,0]
            }
            int j = i + 1;//left
            int k = n - 1;//right
            while (j < k) {
                int sum = numbers[i] + numbers[j] + numbers[k];
                if (sum == 0) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(numbers[i]);
                    list.add(numbers[j]);
                    list.add(numbers[k]);
                    res.add(list);
                    j++;
                    k--;
                    while (j < k && numbers[j] == numbers[j-1]) { // to skip duplicates
                        j++;
                    }
                    while (j < k && numbers[k] == numbers[k+1]) { // to skip duplicates
                        k--;
                    }
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return res;
    }
	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();
		int[] nums1 = {-1, 1, 0};
		int[] nums2 = {1,0,-1,-1,-1,-1,0,1,1,1};
		System.out.println(ts.threeSum(nums2));
	}

}

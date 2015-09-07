package first;

public class LongestIncreasingSubsequence {
	/**
     * Sequence DP. dp[i] means LIS ending in position i.
     * @param nums: The integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    public int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;
        if (n == 0){
            return 0;
        }
        int[] dp = new int[n];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < n; i++){
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--){
                if (nums[i] >= nums[j]){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                    //dp[i] = dp[j] + 1;//this is wrong. dp is not monotone increasing.
                }
            }
            if (dp[i] > max){
                max = dp[i];
            }
        }
        return max;
        
    }

}

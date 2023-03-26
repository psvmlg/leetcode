import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        LongestIncreasingSubsequence s = new LongestIncreasingSubsequence();
        s.lengthOfLIS(new int[]{7, 7, 7, 7, 7, 7, 7});
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(dp[i], max);
                }
            }
        }
        return max;
    }
}

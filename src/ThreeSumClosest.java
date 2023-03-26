import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int finalAns = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (total == target) {
                    return total;
                }
                if (Math.abs(total - target) < minDiff) {
                    minDiff = Math.abs(total - target);
                    finalAns = total;
                }
                if (total > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return finalAns;

    }
}

public class RemoveDuplicateFromSortedArray {

    public static void main(String[] args) {
        RemoveDuplicateFromSortedArray s = new RemoveDuplicateFromSortedArray();
        s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int i = 1;
        int j = 1;
        int lastNum = nums[0];

        while (j < nums.length) {
            if (lastNum != nums[j]) {
                nums[i] = nums[j];
                lastNum = nums[j];
                i++;
            }
            j++;
        }
        return i;
    }
}

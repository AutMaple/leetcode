package moveZeros_283;

public class Solution {
    public static void moveZeros(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            while (fast < nums.length && nums[fast] == 0)
                fast++;
            while (slow < nums.length && nums[slow] != 0)
                slow++;
            if (slow < fast) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                fast++;
                slow++;
            }
        }
    }
}

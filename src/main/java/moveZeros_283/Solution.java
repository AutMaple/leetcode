package moveZeros_283;

import java.util.Arrays;

public class Solution {
    public static void moveZeros(int[] nums) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                if (i != j) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                }
                i++;
            }
            j++;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 0, 0, 1, 1};
        int[] nums = {0, 0, 0, 1};
        Solution1.moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }
}

class Solution1 {
    public static void moveZeros(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != index) {
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }

    public static void swap(int[] nums, int i, int j) {
        if (nums[i] == nums[j])
            return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}

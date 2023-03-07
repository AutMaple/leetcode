package threeSum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int target = -nums[i];
            int tail = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                while (j < tail && nums[j] + nums[tail] > target)
                    tail--;
                // a < b < c
                if (j == tail)
                    break;
                if (nums[j] + nums[tail] == -target) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[tail]));
                }
            }
        }
        return res;
    }
}

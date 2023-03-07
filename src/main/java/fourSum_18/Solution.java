package fourSum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int high = nums.length - 1;
                long sub = (long) target - nums[i] - nums[j];
                for (int k = j + 1; k < nums.length; k++) {
                    if (k > j + 1 && nums[k] == nums[k - 1])
                        continue;
                    long cur = (long) nums[k] + nums[high];
                    while (k < high && cur > sub) {
                        cur = nums[k] + nums[--high];
                    }
                    if (k >= high)
                        break;
                    if (cur == sub) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k], nums[high]));
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {10_0000_0000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> res = fourSum(nums, -294967296);
        System.out.println(res);
    }
}

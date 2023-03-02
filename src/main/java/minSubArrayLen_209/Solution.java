package minSubArrayLen_209;

public class Solution {
    // 2,3,1,2,4,3 target = 7
    // 滑动窗口时间，O(N) 时间复杂度
    public static int minSubArrayLen(int target, int[] nums) {
        int low = 0, high = 0, res = Integer.MAX_VALUE, sum = 0;
        boolean isChanged = false;
        while (high < nums.length) {
            sum += nums[high++];
            while (sum >= target) {
                isChanged = true;
                res = Math.min(res, high - low);
                sum -= nums[low];
                low++;
            }
        }
        return isChanged ? res : 0;
    }
}

class Solution1 {
    // O(N**2) 时间复杂度，超出时间限制
    public static int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        boolean isChanged = false;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    isChanged = true;
                    res = Math.min(res, j - i + 1);
                }
            }
        }
        return isChanged ? res : 0;
    }
}
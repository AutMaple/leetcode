package searchRange_34;

import java.util.Arrays;

public class Solution {
    public static int[] searchRange(int[] nums, int target) {
        return searchRange(nums, 0, nums.length - 1, target);
    }

    private static int[] searchRange(int[] nums, int left, int right, int target) {
        if (left > right)
            return new int[]{-1, -1};
        int mid = left + ((right - left) >> 1);
        if (nums[mid] > target)
            return searchRange(nums, left, mid - 1, target);
        if (nums[mid] < target)
            return searchRange(nums, mid + 1, right, target);

        int[] leftRes = searchRange(nums, left, mid - 1, target);
        int[] rightRes = searchRange(nums, mid + 1, right, target);
        if (leftRes[0] == -1 && rightRes[1] == -1)
            return new int[]{mid, mid};
        if (leftRes[0] == -1)
            return new int[]{mid, rightRes[1]};
        if (rightRes[0] == -1)
            return new int[]{leftRes[0], mid};
        return new int[]{leftRes[0], rightRes[1]};
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 2, 3};
        int[] res = Solution1.searchRange(nums, 0);
//        int[] res = searchRange(nums, 0);
        System.out.println(Arrays.toString(res));
    }
}


class Solution1 {
    public static int[] searchRange(int[] nums, int target) {
        int left = searchRange(nums, target, false);
        int right = searchRange(nums, target, true);
        return new int[]{left, right};
    }

    public static int searchRange(int[] nums, int target, boolean toRightest) {
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] > target)
                right = mid - 1;
            else if (nums[mid] < target)
                left = mid + 1;
            else {
                ans = mid;
                if (toRightest) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return ans;
    }
}

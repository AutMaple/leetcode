package searchInsert_35;

public class Solution {
    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (nums[mid] < target)
                low = mid + 1;
            else if (nums[mid] > target)
                high = mid - 1;
            else
                return mid;
        }
        return low;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int index = searchInsert(nums, 7);
        System.out.println(index);
    }
}

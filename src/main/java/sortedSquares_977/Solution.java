package sortedSquares_977;

public class Solution {
    public static int[] sortedSquares(int[] nums) {
        int low = 0, high = nums.length - 1, i = nums.length;
        int[] res = new int[nums.length];
        while (low <= high) {
            int pre = nums[low], post = nums[high];
            if (Math.abs(pre) > post) {
                res[--i] = pre * pre;
                low++;
            } else {
                res[--i] = post * post;
                high--;
            }
        }
        return res;
    }
}

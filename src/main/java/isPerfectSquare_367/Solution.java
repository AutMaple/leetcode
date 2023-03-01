package isPerfectSquare_367;

public class Solution {
    public static boolean isPerfectSquare(int num) {
        int low = 0, high = num;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            long t = (long) mid * mid;
            if (t < mid)
                low = mid + 1;
            else if (t > mid)
                high = mid - 1;
            else
                return true;
        }
        return false;
    }
}

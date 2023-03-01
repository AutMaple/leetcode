package sqrt_69;

public class Solution {
    public static int mySqrt(int num) {
        int low = 0, high = num;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            // 当数字太大时，会出现溢出的情况
            if ((long) mid * mid <= num) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return high;
    }

    public static void main(String[] args) {
//        int res = mySqrt(19);
        int res = Solution1.mySqrt(19);
        System.out.println(res);
    }
}

class Solution1 {
    public static int mySqrt(int num) {
        int ans = (int) Math.exp(0.5 * Math.log(num));
        return ans * ans <= num ? ans : ans + 1;
    }
}

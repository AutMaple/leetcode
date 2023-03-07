package isHappy_202;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static boolean isHappy(int n) {
        Set<Integer> nums = new HashSet<>();
        int cur = n;
        int sum = 0;
        while (sum != 1) {
            sum = 0;
            while (cur != 0) {
                int a = cur % 10;
                sum += a * a;
                cur /= 10;
            }
            if (nums.contains(sum))
                return false;
            nums.add(sum);
            cur = sum;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean happy = Solution1.isHappy(4);
        System.out.println(happy);
    }
}


class Solution1 {
    public static boolean isHappy(int n) {
        int slow = n, fast = getNext(n);
        while (fast != 1 && slow != fast) {
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        return fast == 1;
    }

    public static int getNext(int n) {
        int sum = 0;
        while (n != 0) {
            int a = n % 10;
            sum += a * a;
            n /= 10;
        }
        return sum;
    }
}

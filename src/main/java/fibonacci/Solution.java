package fibonacci;

public class Solution {
    public static int fibonacci(int n) {
        return fibonacci(1, 1, n);
    }

    public static int fibonacci(int pre, int cur, int n) {
        if (n <= 0)
            return 0;
        if (n < 3)
            return 1;
        if (n == 3)
            return pre + cur;
        return fibonacci(cur, pre + cur, n - 1);
    }

    public static void main(String[] args) {
        int res = Solution1.fibonacci(10);
        int r1 = fibonacci(10);
    }
}

class Solution1 {
    public static int fibonacci(int n) {
        if (n <= 0)
            return 0;
        if (n < 3)
            return 1;
        int pre = 1, cur = 1;
        for (int i = 3; i <= n; i++) {
            int tmp = cur;
            cur = pre + cur;
            pre = tmp;
        }
        return cur;
    }
}

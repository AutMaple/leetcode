package xPowN;

public class Solution {
    public static int power(int x, int n) {
        if (n == 0)
            return 1;
        int t = power(x, n / 2);
        if (n % 2 == 1)
            return t * t * x;
        return t * t;
    }

    public static void main(String[] args) {
        int res = power(10, 5);
        System.out.println(res);
    }
}

package generateMatrix_59;

import java.util.Arrays;

public class Solution {
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, right = n - 1, bottom = n - 1, left = 0;
        int cur = 1;
        while (cur < n * n) {
            // 上
            for (int j = left; j <= right; j++) res[top][j] = cur++;
            top++;

            // 右
            for (int j = top; j <= bottom; j++) res[j][right] = cur++;
            right--;

            // 下
            for (int j = right; j >= left; j--) res[bottom][j] = cur++;
            bottom--;

            // 左
            for (int j = bottom; j >= top; j--) res[j][left] = cur++;
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        System.out.println(Arrays.toString(res));
    }
}

package SpiralOrder_54;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int top = 0, right = n - 1, bottom = m - 1, left = 0;
        int count = 0;
        while (count < m * n) {
            // top
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
                count++;
            }
            if (count >= m * n)
                break;
            top++;
            // right
            for (int i = top; i <= bottom; i++) {
                count++;
                res.add(matrix[i][right]);
            }
            if (count >= m * n)
                break;
            right--;
            // bottom
            for (int i = right; i >= left; i--) {
                count++;
                res.add(matrix[bottom][i]);
            }
            bottom--;
            // left
            for (int i = bottom; i >= top; i--) {
                count++;
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}

class Solution1 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int top = 0, right = matrix[0].length - 1, bottom = matrix.length - 1, left = 0;
        while (true) {
            // top
            for (int i = left; i <= right; i++) res.add(matrix[top][i]);
            top++;
            if (top > bottom) break;

            // right
            for (int i = top; i <= bottom; i++) res.add(matrix[i][right]);
            right--;
            if (right < left) break;

            // bottom
            for (int i = right; i >= left; i--) res.add(matrix[bottom][i]);
            bottom--;
            if (top > bottom) break;

            // left
            for (int i = bottom; i >= top; i--) res.add(matrix[i][left]);
            left++;
            if (right < left) break;
        }
        return res;
    }
}

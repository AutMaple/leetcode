package combinationSum3_216;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static String name;

    /**
     * 数据范围 1 - 9， 在 1 - 9 中取 k 个不重复的数，使得这些数的和为 n
     */
    public List<List<Integer>> res = new ArrayList<>();
    public List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(n, k, 1, 0);
        return res;
    }

    public void dfs(int n, int k, int start, int sum) {
        if (path.size() == k) {
            if (sum == n)
                res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= 10 - (k - path.size()); i++) {
            sum += i;
            if (sum > n)
                break;
            path.add(i);
            dfs(n, k, i + 1, sum);
            path.remove(path.size() - 1);
            sum -= i;
        }
    }
}

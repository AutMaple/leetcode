package combinationSunn_39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 遇到相同元素不计算顺序的问题，我们在搜索的时候就需要 按某种顺序搜索
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target, 0);
        return res;
    }

    public void dfs(int[] candidates, int sum, int target, int startIndex) {
        if (sum > target)
            return;

        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            int num = candidates[i];
            path.add(num);
            dfs(candidates, sum + num, target, i);
            path.remove(path.size() - 1);
        }
    }
}

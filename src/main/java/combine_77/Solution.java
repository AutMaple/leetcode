package combine_77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> curNums = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTracking(1, n, k);
        return res;
    }

    public void backTracking(int low, int high, int k) {
        if (curNums.size() == k) {
            res.add(new ArrayList<>(curNums));
            return;
        }
        // high - low 是多叉树的宽度， k 则是多叉树的高度
        // high - low 控制循环的次数，i 表示当前选择，i <= high 表示剩余的选择
        for (int i = low; i <= high; i++) {
            curNums.add(i);
            backTracking(i + 1, high, k);
            curNums.remove(curNums.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> combine = new Solution().combine(1, 1);
        System.out.println(combine);
    }
}
